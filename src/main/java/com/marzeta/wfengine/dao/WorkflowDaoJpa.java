package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.Workflow;

public class WorkflowDaoJpa extends CommonDaoJpa<Workflow, Long> implements WorkflowDao {
	public WorkflowDaoJpa() {
		super(Workflow.class);
	}
}