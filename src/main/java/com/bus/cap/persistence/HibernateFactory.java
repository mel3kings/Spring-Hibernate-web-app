package com.bus.cap.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class HibernateFactory  {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public Session createSession(){
		Session session = sessionFactory.getCurrentSession();
		if(!session.isOpen()){
			return sessionFactory.openSession();
		}else{
			return session;
		}
	}

}
