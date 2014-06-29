package com.marzeta.wfengine.model;

import com.marzeta.wfengine.dao.WorkflowDef;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ActivityDefEntity extends ActivityCommonEntity{
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private WorkflowDef workflowDef = null;
	
	public WorkflowDef getWorkflowDef() {
		return workflowDef;
	}

	public void setWorkflowDef(WorkflowDef workflowDef) {
		this.workflowDef = workflowDef;
	}
}
