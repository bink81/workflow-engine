package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.WorkflowDef;

public class WorkflowDefDaoJpa extends CommonDaoJpa<WorkflowDef, Long> implements WorkflowDefDao {
	public WorkflowDefDaoJpa() {
		super(WorkflowDef.class);
	}
}