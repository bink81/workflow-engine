package com.marzeta.wfengine.utils;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.ContextDef;
import com.marzeta.wfengine.model.Workflow;
import com.marzeta.wfengine.model.WorkflowDef;

public class TestUtils {
	@NotNull
	public static Workflow createWorkflow() {
		ContextDef cd = new ContextDef();
		WorkflowDef wd = new WorkflowDef("createWorkflow", cd);
		return new Workflow(wd);
	}

}
