package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.ContextDef;

public class ContextDefDaoJpa extends CommonDaoJpa<ContextDef, Long> implements ContextDefDao {
	public ContextDefDaoJpa() {
		super(ContextDef.class);
	}
}