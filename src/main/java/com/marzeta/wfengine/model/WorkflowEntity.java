package com.marzeta.wfengine.model;

import java.util.ArrayList;

import com.marzeta.wfengine.dao.WorkflowDef;
import com.marzeta.wfengine.service.Activity;
import com.marzeta.wfengine.service.Context;
import com.marzeta.wfengine.service.Transition;

public abstract class WorkflowEntity extends CommonEntity {
	private static final long serialVersionUID = 1L;
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	private WorkflowDef workflowDef = null;
	private Context context = null;

	public WorkflowDef getWorkflowDef() {
		return workflowDef;
	}

	public void setWorkflowDef(WorkflowDef workflowDef) {
		this.workflowDef = workflowDef;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

}
