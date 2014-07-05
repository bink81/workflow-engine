package com.marzeta.wfengine.utils;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.dao.ContextDef;
import com.marzeta.wfengine.dao.WorkflowDef;
import com.marzeta.wfengine.service.Workflow;

public class TestUtils {
	@NotNull
	public static Workflow createWorkflow() {
		ContextDef cd = new ContextDef();
		WorkflowDef wd = new WorkflowDef("createWorkflow", cd);
		return new Workflow(wd);
	}

}
