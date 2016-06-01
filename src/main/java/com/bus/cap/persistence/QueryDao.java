package com.bus.cap.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bus.cap.entities.Business;
import com.bus.cap.util.EntityFinder;

@Repository
public class QueryDao {
	@Autowired
	HibernateFactory factory;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void save(Object o) throws SQLException {
		Session session = factory.createSession();
		session.save(o);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Object> query (String identifier, String column,Object objectType) throws SQLException {
		Session session = factory.createSession();
		ArrayList<Object> o = null;
		if (objectType instanceof Business) {
			Query q = session.createQuery("from Business where " + column + " = '" + identifier + "'");
			o = (ArrayList<Object>) q.list();
		}
		return o;
	}

	public void delete(Object o) throws SQLException {
		Session session = factory.createSession();
		session.delete(o);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void update(Object o) throws SQLException {
		Session session = factory.createSession();
		if(EntityFinder.isValidEntity(o))
			session.saveOrUpdate(o);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Object get(Long id, Class<?> cls) {
		if(EntityFinder.isValidEntity(o)) {
			Session session = factory.createSession();
			System.out.println(cls.getName() + " id: " + id);
			return session.get(cls, id);
		}
		return null;
	}
}
