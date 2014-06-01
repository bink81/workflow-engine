package com.marzeta.wfengine.model;

import com.marzeta.wfengine.dao.WorkflowDef;

public abstract class ActivityDefEntity extends ActivityCommonEntity{
	private static final long serialVersionUID = 1L;
	private WorkflowDef workflowDef = null;
	
	public WorkflowDef getWorkflowDef() {
		return workflowDef;
	}

	public void setWorkflowDef(WorkflowDef workflowDef) {
		this.workflowDef = workflowDef;
	}
}
