package com.marzeta.wfengine.service;

import java.util.ArrayList;
import java.util.Date;

import com.marzeta.wfengine.dao.ContextDef;
import com.marzeta.wfengine.dao.EmptyActivityDef;
import com.marzeta.wfengine.dao.WorkActivityDef;
import com.marzeta.wfengine.dao.WorkflowDef;

public class TestWorkflowEngine extends ActivityEngine {
	private static final long serialVersionUID = 1L;

	private final Workflow newWorkflow;

	public TestWorkflowEngine() {
		super("TestWorkflowEngine");
		newWorkflow = createTestWorkflow();
	}

	@Override
	public ArrayList<Activity> getActivities() {
		ArrayList<Activity> activities = new ArrayList<Activity>(); // newWorkflow.getActivities();
		activities.add(newWorkflow.getNextActivity());
		getStorage().saveObjectToFile(newWorkflow);
		return activities;
	}

	private Workflow createTestWorkflow() {
		ContextDef contextDef = new ContextDef();
		contextDef.getContextObjectDefs().put("CURRENT_DATE", new Date());
		WorkflowDef workflowDef = new WorkflowDef("TestWorkflowDef", contextDef);

		WorkActivityDef workActivityDef = new WorkActivityDef(workflowDef, "Work");
		workflowDef.addActivity(workActivityDef);
		EmptyActivityDef emptyActivityDef = new EmptyActivityDef(workflowDef, "Empty");
		workflowDef.addActivity(emptyActivityDef);

		workflowDef.createLink(workflowDef.getStartActivityDef(), workActivityDef);
		workflowDef.createLink(workActivityDef, emptyActivityDef, WorkActivityDef.Result.YES);
		workflowDef.createLink(workActivityDef, workflowDef.getStopActivityDef(), WorkActivityDef.Result.NO);
		workflowDef.createLink(emptyActivityDef, workflowDef.getStopActivityDef());

		getStorage().saveObjectToFile(workflowDef);
		// we cannot check if we can read it because entities are not beans anymore
		// workflowDef = (WorkflowDef) getStorage().readFile(filename);

		return workflowDef.startWorkflow();
	}
}
