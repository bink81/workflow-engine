package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.TransitionDef;

public class TransitionDefDaoJpa extends CommonDaoJpa<TransitionDef, Long> implements TransitionDefDao {
	public TransitionDefDaoJpa() {
		super(TransitionDef.class);
	}
}