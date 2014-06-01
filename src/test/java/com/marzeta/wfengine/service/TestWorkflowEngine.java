package com.marzeta.wfengine.service;

import java.util.ArrayList;
import java.util.Date;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.dao.ActivityDef;
import com.marzeta.wfengine.dao.ContextDef;
import com.marzeta.wfengine.dao.EmptyActivityDef;
import com.marzeta.wfengine.dao.WorkActivityDef;
import com.marzeta.wfengine.dao.WorkflowDef;

public class TestWorkflowEngine extends ActivityEngine {
	private static final long serialVersionUID = 1L;
	private Workflow newWorkflow;

	public TestWorkflowEngine() throws ConfigurationException {
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

	private Workflow createTestWorkflow() throws ConfigurationException {
		ContextDef contextDef = new ContextDef();
		contextDef.getContextObjectDefs().put("CURRENT_DATE", new Date());
		WorkflowDef workflowDef = new WorkflowDef("TestWorkflowDef", contextDef);

		ActivityDef startActivityDef = new ActivityDef(workflowDef, ActivityDef.START);
		WorkActivityDef workActivityDef = new WorkActivityDef(workflowDef, "Work");
		EmptyActivityDef emptyActivityDef = new EmptyActivityDef(workflowDef, "Empty");
		ActivityDef stopActivityDef = new ActivityDef(workflowDef, ActivityDef.STOP);

		workflowDef.createLink(startActivityDef, workActivityDef);
		workflowDef.createLink(workActivityDef, emptyActivityDef, WorkActivityDef.Result.YES);
		workflowDef.createLink(workActivityDef, stopActivityDef, WorkActivityDef.Result.NO);
		workflowDef.createLink(emptyActivityDef, stopActivityDef);
		
		String filename = getStorage().saveObjectToFile(workflowDef);
		workflowDef = (WorkflowDef) getStorage().readFile(filename); // check if we can also read it

		return workflowDef.startWorkflow();
	}
}
