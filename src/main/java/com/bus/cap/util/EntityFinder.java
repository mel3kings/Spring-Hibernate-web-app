package com.bus.cap.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;

import org.reflections.Reflections;

import com.bus.cap.constants.Constant;
import com.bus.cap.entities.Admin;
import com.bus.cap.entities.Business;

public class EntityFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Business bus = new Business();
		if(isValidEntity(bus)) {
			Class<?> objectClass = bus.getClass();
			HashMap<String, Object> map = new HashMap();
			map.put("BusinessName", "Test Business");
			map.put("BusinessAddress", "Test BusinessAddress");
			map.put("BusinessCity", "Test BusinessCity");
			map.put("Description", "Test Description");
			map.put("Admin", new ArrayList<Admin>());
			Object updateObject = objectClass.cast(bus);
			Set<String> set = map.keySet();
			Iterator i = set.iterator();
			while(i.hasNext()) {
				try {
					String key = i.next().toString();
					boolean isNonString = false;
					Class<?> valueClass = map.get(key).getClass();
					if(!valueClass.isInstance(new String())) {
						if(valueClass.getInterfaces()[0] != null) 
							valueClass = valueClass.getInterfaces()[0];
						isNonString = true;
					}

					Method method = objectClass.getMethod("set" + key, valueClass);
					if(isNonString)
						method.invoke(updateObject,map.get(key));
					else
						method.invoke(updateObject,map.get(key).toString());
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Set<Class<?>> getAllEntities() {
		Reflections ref = new Reflections(Constant.ENTITY_PACKAGE); //get entity package from properties file?
		
		return ref.getTypesAnnotatedWith(Entity.class);
	}
	
	public static boolean isValidEntity(Object o) {
		Set<Class<?>> set = getAllEntities();
		Iterator i = set.iterator();
		while(i.hasNext()) {
			Class<?> cls = (Class<?>)i.next();
			if(cls.isInstance(o)) {
				return true;
			}
		}
		return false;
	}
}
