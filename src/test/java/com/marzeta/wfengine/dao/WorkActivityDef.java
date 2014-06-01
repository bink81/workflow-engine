package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.commons.IResult;

public class WorkActivityDef extends ActivityDef {
	private static final long serialVersionUID = 1L;
	public enum Result implements IResult {
		YES, NO, MAYBE
	}
	
	public WorkActivityDef() {}
	public WorkActivityDef(WorkflowDef workflowDef, String name) {
		super(workflowDef, name);
	}

	@Override
	public IResult execute() {
		return Result.YES;
	}
}
