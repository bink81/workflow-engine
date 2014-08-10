package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.ContextObject;

public class ContextObjectDaoJpa extends CommonDaoJpa<ContextObject, Long> implements ContextObjectDao {
	public ContextObjectDaoJpa() {
		super(ContextObject.class);
	}
}