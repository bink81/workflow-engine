package com.marzeta.wfengine.service;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;

import com.marzeta.wfengine.commons.Result;
import com.marzeta.wfengine.dao.EmptyActivityDef;
import com.marzeta.wfengine.dao.WorkActivityDef;
import com.marzeta.wfengine.model.Activity;
import com.marzeta.wfengine.model.ContextDef;
import com.marzeta.wfengine.model.ContextObjectDef;
import com.marzeta.wfengine.model.Workflow;
import com.marzeta.wfengine.model.WorkflowDef;

public class TestWorkflowEngine extends ActivityEngine {
	private final Workflow newWorkflow;

	Session session;

	public TestWorkflowEngine(Session session) {
		super("TestWorkflowEngine");
		this.session = session;
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
		WorkflowDef workflowDef = new WorkflowDefService(session).createWorkflowDef();
		ContextDef contextDef = workflowDef.getContextDef();
		contextDef.getContextObjectDefs().add(new ContextObjectDef(contextDef, "CURRENT_DATE", new Date().toString()));

		WorkActivityDef workActivityDef = new WorkActivityDef(workflowDef, "Work");
		workflowDef.addActivity(workActivityDef);
		EmptyActivityDef emptyActivityDef = new EmptyActivityDef(workflowDef, "Empty");
		workflowDef.addActivity(emptyActivityDef);

		workflowDef.createLink(workflowDef.getStartActivityDef(), workActivityDef);
		workflowDef.createLink(workActivityDef, emptyActivityDef, Result.OK);
		workflowDef.createLink(workActivityDef, workflowDef.getStopActivityDef(), Result.NOK);
		workflowDef.createLink(emptyActivityDef, workflowDef.getStopActivityDef());

		getStorage().saveObjectToFile(workflowDef);
		// we cannot check if we can read it because entities are not beans anymore
		// workflowDef = (WorkflowDef) getStorage().readFile(filename);

		return new WorkflowService(session).createWorkflow(workflowDef);
	}
}
