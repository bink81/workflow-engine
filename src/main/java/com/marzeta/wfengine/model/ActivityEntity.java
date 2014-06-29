package com.marzeta.wfengine.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.dao.ActivityDef;
import com.marzeta.wfengine.service.Workflow;

@MappedSuperclass
public abstract class ActivityEntity extends ActivityCommonEntity {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Workflow workflow = null;
	@ManyToOne
	private IResult result = null;
	@ManyToOne
	private ActivityDef activityDef = null;

	public void setResult(IResult newResult) {
		this.result = newResult;
	}

	public IResult getResult() {
		return result;
	}

	public ActivityDef getActivityDef() {
		return activityDef;
	}

	public void setActivityDef(ActivityDef activityDef) {
		this.activityDef = activityDef;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	@Override
	public String toString() {
		return super.toString() + ",result=" + getResult();
	}
}
