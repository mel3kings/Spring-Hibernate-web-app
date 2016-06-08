package com.bus.cap.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.bus.cap.constants.Constant;
import com.bus.cap.entities.Album;
import com.bus.cap.entities.Customer;
import com.bus.cap.entities.Event;
import com.bus.cap.persistence.AlbumDao;
import com.bus.cap.persistence.QueryDao;
import com.bus.cap.util.StringUtil;

@Controller
public class AlbumController {
	
	private static final Logger log = Logger.getLogger(EventController.class);
	
	@Autowired
	QueryDao dao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value="/album/{id}", method = RequestMethod.GET)
	public ModelAndView viewAlbum(@PathVariable("id") Long id){
		ModelAndView map = new ModelAndView();
		map.setViewName("album/details");
		Album album = (Album) dao.get(id, Album.class);
		map.addObject("album",album);
		return map;
	}
	
	@RequestMapping(value={"/event/{customer_id}/{event_id}/album"}, method= RequestMethod.GET)
	public ModelAndView createAlbumPage(@PathVariable("event_id") Long event_id, @PathVariable("customer_id") Long customer_id){
		ModelAndView map = new ModelAndView();
		map.setViewName("album/create");
		map.addObject("event",(Event)dao.get(event_id, Event.class));
		map.addObject("customer",(Customer) dao.get(customer_id, Customer.class));
		return map;
	}
	
	@RequestMapping(value={"/event/createAlbum", "/createAlbum"}, method= RequestMethod.POST)
	public String create(@ModelAttribute Album album, ModelMap map){
		try {
			System.out.println("saving album..");
			dao.save(album);
		} catch (Exception e) {
			System.out.println("ASDAS");
			e.printStackTrace();
			return "event/fail";
		}
		map.addAttribute("name", album.getName());
		return "event/success";
	}
	
	@RequestMapping(value = {"/album/uploadMedia/{albumId}","/uploadMedia/{albumId}"}, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void uploadMedia(
		@RequestParam("uploadFile") MultipartFile multipartFile, @PathVariable("albumId") Long albumId) {
		AlbumDao albumDao = new AlbumDao();
		String fileName = multipartFile.getOriginalFilename();
		log.debug("uploading media under albumid: " + albumId);
		Album album = albumDao.getLoadedAlbum(albumId);
		Event event = album.getEvent();
		String eventName = event.getEventName();
		String albumName = album.getName();
		String directory = Constant.FILE_PATH+StringUtil.replaceSpace(eventName) + "\\" + StringUtil.replaceSpace(albumName);
		//String directory = Constant.FILE_PATH;
		OutputStream os;
		InputStream is;
		try {
			File file = new File(directory + fileName);
			File directoryFolder = new File(directory);
			os = new FileOutputStream(file);
			is = multipartFile.getInputStream();
			
			if(!directoryFolder.exists())
				directoryFolder.mkdirs();
			IOUtils.copy(is, os);
			if(file.exists()) {
				//Media media = new Media();
				//media.setAlbum(album);
				//media.setMediaLocation(file.getAbsolutePath());
				log.debug("saved media under albumid: " + albumId);
			}
			is.close(); os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
