package com.sgc.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UtilHibernate {
	
	//@Autowired
	private SessionFactory sessionFactory;
	
	public <T> void persist(T entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public <T> void save(T entity) {
		this.getCurrentSession().save(entity);
	}
	
	public <T> void update(T entity) {
		this.getCurrentSession().update(entity);
	}
	
	public <T> void delete(T entity) {
		this.getCurrentSession().delete(entity);
	}
	
	public <T> T get(Class<T> entityClass, Serializable primaryKey) {
		return this.getCurrentSession().get(entityClass, primaryKey);
	}
	
	public <T> T load(Class<T> entityClass, Serializable primaryKey) {
		return this.getCurrentSession().load(entityClass, primaryKey);
	}
	
	protected final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
   }
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
