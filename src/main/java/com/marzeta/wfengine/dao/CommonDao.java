package com.marzeta.wfengine.dao;

import java.io.Serializable;

import org.hibernate.Session;

import com.marzeta.wfengine.model.common.EntityCommon;

public interface CommonDao<T extends EntityCommon, ID extends Serializable> {
	T retrieveById(ID id);

	long create(T entity);

	T update(T entity);

	void setSession(Session session);
}