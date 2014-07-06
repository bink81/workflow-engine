package com.marzeta.wfengine.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.TransitionCommon;

@Entity
public class Transition extends TransitionCommon {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull
	private Activity fromActivity = Activity.DUMMY;

	@ManyToOne
	@NotNull
	private Activity toActivity = Activity.DUMMY;

	@ManyToOne
	@NotNull
	private Workflow workflow = Workflow.DUMMY;

	protected Transition() {
	}

	public Transition(@NotNull Workflow workflow, @NotNull Activity fromActivity, @NotNull Activity toActivity) {
		this.workflow = workflow;
		this.fromActivity = fromActivity;
		this.toActivity = toActivity;
	}

	public Activity getFromActivity() {
		return fromActivity;
	}

	public Activity getToActivity() {
		return toActivity;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	@Override
	public String toString() {
		return "Transition[ " + super.toString() + "fromActivity=" + fromActivity + ", toActivity=" + toActivity
				+ ", workflow=" + workflow + "]";
	}
}
