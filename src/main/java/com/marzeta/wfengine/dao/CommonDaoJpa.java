package com.marzeta.wfengine.dao;

import java.io.Serializable;

import org.hibernate.Session;

import com.marzeta.wfengine.model.common.EntityCommon;

public abstract class CommonDaoJpa<T extends EntityCommon, ID extends Serializable> implements CommonDao<T, ID> {
	private Class<T> persistentClass;

	private Session session;

	public CommonDaoJpa(Class<T> persistentClass) {
		this.setPersistentClass(persistentClass);
	}

	@Override
	public T retrieveById(ID id) {
		return (T) getSession().get(getPersistentClass(), id);
	}

	private Session getSession() {
		return session;
	}

	@Override
	public long create(T entity) {
		getSession().save(entity);
		return entity.getId();
	}

	@Override
	public T update(T entity) {
		getSession().update(entity);
		T savedEntity = (T) getSession().get(getPersistentClass(), entity.getId());
		return savedEntity;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}
}