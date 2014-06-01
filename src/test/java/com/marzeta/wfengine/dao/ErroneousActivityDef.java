package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.service.ActivityEngine;

public class ErroneousActivityDef extends ActivityDef {
	private static final long serialVersionUID = 1L;

	public ErroneousActivityDef() {
		super(null, "ErroneousActivityDef");
	}

	public ErroneousActivityDef(WorkflowDef workflowDef, String name) {
		super(workflowDef, name);
	}

	@Override
	public IResult execute() throws Throwable {
		System.out.println("Doing ErroneousActivityDef...");
		throw new Exception(ActivityEngine.EXCEPTION_TEST_TEXT);
	}
}
