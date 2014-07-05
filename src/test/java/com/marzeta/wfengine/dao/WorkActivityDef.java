package com.marzeta.wfengine.dao;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.WorkflowDef;

public class WorkActivityDef extends ActivityDef {
	private static final long serialVersionUID = 1L;

	public enum Result implements IResult {
		@NotNull
		YES, @NotNull
		NO, @NotNull
		MAYBE
	}

	public WorkActivityDef(@NotNull WorkflowDef workflowDef, String name) {
		super(workflowDef, name);
	}

	@Override
	public IResult execute() {
		return Result.YES;
	}
}
