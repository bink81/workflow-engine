package com.marzeta.wfengine.dao;

import java.io.Serializable;

import com.marzeta.wfengine.model.common.EntityCommon;

public interface CommonDao<T extends EntityCommon, ID extends Serializable> {
	T retrieveById(ID id);

	long create(T entity);

	T update(T entity);
}