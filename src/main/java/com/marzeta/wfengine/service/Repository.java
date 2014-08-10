package com.marzeta.wfengine.service;

import org.hibernate.Session;

import com.marzeta.wfengine.model.common.EntityCommon;

public class Repository {
	public <T extends EntityCommon> T retrieveById(Class<T> clazz, long id) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		return (T) session.get(clazz, id);
	}

	public <T extends EntityCommon> long create(T entity) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		return ((EntityCommon) entity).getId();
	}

	public <T extends EntityCommon> T update(T entity) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		return entity;
	}
}
