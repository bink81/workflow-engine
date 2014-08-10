package com.marzeta.wfengine.dao;

import java.io.Serializable;

import com.marzeta.wfengine.model.common.EntityCommon;

public interface CommonDao<T extends EntityCommon, ID extends Serializable> {
	T findById(ID id);

	long save(T entity);

	T update(T entity);
}