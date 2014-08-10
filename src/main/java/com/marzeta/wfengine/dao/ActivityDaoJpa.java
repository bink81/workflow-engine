package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.Activity;

public class ActivityDaoJpa extends CommonDaoJpa<Activity, Long> implements ActivityDao {
	public ActivityDaoJpa() {
		super(Activity.class);
	}
}