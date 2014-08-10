package com.marzeta.wfengine.dao;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.Result;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.WorkflowDef;

public class WorkActivityDef extends ActivityDef {
	private static final long serialVersionUID = 1L;

	public WorkActivityDef(@NotNull WorkflowDef workflowDef, @NotNull String name) {
		super(workflowDef, name);
	}

	@Override
	public Result execute() {
		return Result.OK;
	}
}
