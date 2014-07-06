package com.marzeta.wfengine.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.commons.OKResult;
import com.marzeta.wfengine.model.common.TransitionCommon;

@Entity
public class TransitionDef extends TransitionCommon {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull
	private ActivityDef fromActivityDef = ActivityDef.DUMMY;

	@ManyToOne
	@NotNull
	private ActivityDef toActivityDef = ActivityDef.DUMMY;

	@ManyToOne
	@NotNull
	private WorkflowDef workflowDef = WorkflowDef.DUMMY;

	@ManyToOne
	@NotNull
	private IResult result = OKResult.OK;

	protected TransitionDef() {
	}

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
