package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.Transition;

public class TransitionDaoJpa extends CommonDaoJpa<Transition, Long> implements TransitionDao {
	public TransitionDaoJpa() {
		super(Transition.class);
	}
}