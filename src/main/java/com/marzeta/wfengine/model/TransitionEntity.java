package com.marzeta.wfengine.model;

import com.marzeta.wfengine.dao.TransitionDef;
import com.marzeta.wfengine.service.Activity;
import com.marzeta.wfengine.service.Workflow;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TransitionEntity extends TransitionCommonEntity{
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Activity fromActivity = null;
	@ManyToOne
	private Activity toActivity = null;
	@ManyToOne
	private Workflow workflow = null;
	@ManyToOne
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
