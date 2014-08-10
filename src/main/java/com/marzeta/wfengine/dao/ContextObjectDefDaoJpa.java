package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.ContextObjectDef;

public class ContextObjectDefDaoJpa extends CommonDaoJpa<ContextObjectDef, Long> implements ContextObjectDefDao {
	public ContextObjectDefDaoJpa() {
		super(ContextObjectDef.class);
	}
}