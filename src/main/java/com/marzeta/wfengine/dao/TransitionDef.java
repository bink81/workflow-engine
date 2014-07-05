package com.marzeta.wfengine.dao;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.commons.OKResult;
import com.marzeta.wfengine.model.TransitionCommon;

public class TransitionDef extends TransitionCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	private final ActivityDef fromActivityDef;

	@NotNull
	private final ActivityDef toActivityDef;

	@NotNull
	private final WorkflowDef workflowDef;

	@NotNull
	private final IResult result;

	public TransitionDef(@NotNull WorkflowDef workflowDef, @NotNull ActivityDef fromActivityDef,
			@NotNull ActivityDef toActivityDef) {
		this(workflowDef, fromActivityDef, toActivityDef, OKResult.OK);
	}

	public TransitionDef(@NotNull WorkflowDef workflowDef, @NotNull ActivityDef fromActivityDef,
			@NotNull ActivityDef toActivityDef, @NotNull IResult result) {
		super();
		this.workflowDef = workflowDef;
		this.fromActivityDef = fromActivityDef;
		this.toActivityDef = toActivityDef;
		this.result = result;
	}

	@NotNull
	public ActivityDef getFromActivityDef() {
		return fromActivityDef;
	}

	@NotNull
	public ActivityDef getToActivityDef() {
		return toActivityDef;
	}

	@NotNull
	public WorkflowDef getWorkflowDef() {
		return workflowDef;
	}

	@NotNull
	public IResult getResult() {
		return result;
	}

	@Override
	public String toString() {
		return fromActivityDef.getName() + "->" + toActivityDef.getName() + "(" + result.name() + ")";
	}
}
