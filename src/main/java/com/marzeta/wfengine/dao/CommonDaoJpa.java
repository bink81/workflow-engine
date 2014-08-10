package com.marzeta.wfengine.dao;

import java.io.Serializable;

import org.hibernate.Session;

import com.marzeta.wfengine.model.common.EntityCommon;
import com.marzeta.wfengine.service.HibernateSessionManager;

public abstract class CommonDaoJpa<T extends EntityCommon, ID extends Serializable> implements CommonDao<T, ID> {
	private Class<T> persistentClass;

	public CommonDaoJpa(Class<T> persistentClass) {
		this.setPersistentClass(persistentClass);
	}

	@Override
	public T retrieveById(ID id) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		return (T) session.get(getPersistentClass(), id);
	}

	@Override
	public long create(T entity) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		return entity.getId();
	}

	@Override
	public T update(T entity) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		T saved = (T) session.get(getPersistentClass(), entity.getId());
		session.getTransaction().commit();
		return saved;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
}