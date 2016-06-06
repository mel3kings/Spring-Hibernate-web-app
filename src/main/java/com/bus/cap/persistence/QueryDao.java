package com.bus.cap.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bus.cap.entities.Album;
import com.bus.cap.entities.Business;
import com.bus.cap.entities.Media;
import com.bus.cap.util.EntityFinder;

@Repository
public class QueryDao {
	private static final Logger log = Logger.getLogger(QueryDao.class);
	
	@Autowired
	HibernateFactory factory;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Object o) throws SQLException {
		Session session = factory.createSession();
		session.save(o);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object> query (String identifier, String column,Object objectType) throws SQLException {
		Session session = factory.createSession();
		ArrayList<Object> result = null;
		Query query = null;
		if (objectType instanceof Business) {
			query = session.createQuery("from Business where " + column + " = '" + identifier + "'");
			result = (ArrayList<Object>) query.list();
		} else if(objectType instanceof Album){
			query = session.createQuery("from Album where " + column + " = '" + identifier + "'");
			result= (ArrayList<Object>) query.list();
		} else if(objectType instanceof Media){
			query = session.createQuery("from Media where " + column + " ='" + identifier + "'");
			result = (ArrayList<Object>)query.list();
		}
		return result;
	}
	
	public void delete(Object o) throws SQLException {
		Session session = factory.createSession();
		session.delete(o);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(Object o) throws SQLException {
		Session session = factory.createSession();
		if(EntityFinder.isValidEntity(o))
			session.saveOrUpdate(o);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Object get(Long id, Class<?> cls) {
		Session session = factory.createSession();
		System.out.println(cls.getName() + " id: " + id);
		return session.get(cls, id);
	}

}
