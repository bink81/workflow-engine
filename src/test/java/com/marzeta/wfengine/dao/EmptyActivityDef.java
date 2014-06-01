package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.commons.IResult;

public class EmptyActivityDef extends ActivityDef {
	private static final long serialVersionUID = 1L;
	
	public EmptyActivityDef() {
		super(null, "EmptyActivityDef");
	}

	public EmptyActivityDef(WorkflowDef workflowDef, String name) {
		super(workflowDef, name);
	}

	@Override
	public IResult execute() {
		System.out.println("Doing something with a result = null\n");
		return null;
	}
}
