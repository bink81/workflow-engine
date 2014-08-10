package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.ActivityDef;

public class ActivityDefDaoJpa extends CommonDaoJpa<ActivityDef, Long> implements ActivityDefDao {
	public ActivityDefDaoJpa() {
		super(ActivityDef.class);
	}
}