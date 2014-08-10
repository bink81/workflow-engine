package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.Context;

public class ContextDaoJpa extends CommonDaoJpa<Context, Long> implements ContextDao {
	public ContextDaoJpa() {
		super(Context.class);
	}
}