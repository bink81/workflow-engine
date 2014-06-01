package com.marzeta.wfengine.model;

import com.marzeta.wfengine.dao.TransitionDef;
import com.marzeta.wfengine.service.Activity;
import com.marzeta.wfengine.service.Workflow;

public abstract class TransitionEntity extends TransitionCommonEntity{
	private static final long serialVersionUID = 1L;
	private Activity fromActivity = null;
	private Activity toActivity = null;
	private Workflow workflow = null;
	private TransitionDef transitionDef = null;

	public Activity getFromActivity() {
		return fromActivity;
	}

	public void setFromActivity(Activity fromActivity) {
		this.fromActivity = fromActivity;
	}

	public Activity getToActivity() {
		return toActivity;
	}

	public void setToActivity(Activity toActivity) {
		this.toActivity = toActivity;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public TransitionDef getTransitionDef() {
		return transitionDef;
	}

	public void setTransitionDef(TransitionDef transitionDef) {
		this.transitionDef = transitionDef;
	}
}
