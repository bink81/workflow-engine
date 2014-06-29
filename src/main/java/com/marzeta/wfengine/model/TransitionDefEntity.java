package com.marzeta.wfengine.model;

import com.marzeta.wfengine.dao.ActivityDef;
import com.marzeta.wfengine.dao.WorkflowDef;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TransitionDefEntity extends TransitionCommonEntity {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private ActivityDef fromActivityDef = null;
	@ManyToOne
	private ActivityDef toActivityDef = null;
	@ManyToOne
	private WorkflowDef workflowDef = null;

	public ActivityDef getFromActivityDef() {
		return fromActivityDef;
	}
	public void setFromActivityDef(ActivityDef fromActivityDef) {
		this.fromActivityDef = fromActivityDef;
	}

	public ActivityDef getToActivityDef() {
		return toActivityDef;
	}

	public void setToActivityDef(ActivityDef toActivityDef) {
		this.toActivityDef = toActivityDef;
	}

	public WorkflowDef getWorkflowDef() {
		return workflowDef;
	}

	public void setWorkflowDef(WorkflowDef workflowDef) {
		this.workflowDef = workflowDef;
	}
}
