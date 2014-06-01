package com.marzeta.wfengine.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.dao.ActivityDef;
import com.marzeta.wfengine.service.Workflow;

public abstract class ActivityEntity extends ActivityCommonEntity {
	private static final long serialVersionUID = 1L;
	private Workflow workflow = null;
	private IResult result = null;
	private ActivityDef activityDef = null;

	public void setResult(IResult newResult) {
		this.result = newResult;
	}

	public IResult getResult() {
		return result;
	}

	@NotNull
	public ActivityDef getActivityDef() {
		return activityDef;
	}

	public void setActivityDef(ActivityDef activityDef) {
		this.activityDef = activityDef;
	}

	@Nullable
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
