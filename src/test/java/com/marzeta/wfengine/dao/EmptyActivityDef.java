package com.marzeta.wfengine.dao;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.Result;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.WorkflowDef;

public class EmptyActivityDef extends ActivityDef {
	private static final long serialVersionUID = 1L;

	public EmptyActivityDef(@NotNull WorkflowDef workflowDef, @NotNull String name) {
		super(workflowDef, name);
	}

	@Override
	public Result execute() {
		System.out.println("Doing something with a result = null\n");
		return null;
	}
}
