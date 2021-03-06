package com.marzeta.wfengine.dao;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.Result;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.WorkflowDef;
import com.marzeta.wfengine.service.ActivityEngine;

public class ErroneousActivityDef extends ActivityDef {
	private static final long serialVersionUID = 1L;

	public ErroneousActivityDef(@NotNull WorkflowDef workflowDef, @NotNull String name) {
		super(workflowDef, name);
	}

	@Override
	public Result execute() throws Throwable {
		System.out.println("Doing ErroneousActivityDef...");
		throw new Exception(ActivityEngine.EXCEPTION_TEST_TEXT);
	}
}
