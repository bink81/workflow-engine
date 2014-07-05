package com.marzeta.wfengine.model;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.TransitionCommon;

public class Transition extends TransitionCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	private final Activity fromActivity;

	@NotNull
	private final Activity toActivity;

	@NotNull
	private final Workflow workflow;

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
