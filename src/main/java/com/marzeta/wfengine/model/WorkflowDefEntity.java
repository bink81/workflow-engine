package com.marzeta.wfengine.model;

import java.util.ArrayList;

import com.marzeta.wfengine.dao.ActivityDef;
import com.marzeta.wfengine.dao.ContextDef;
import com.marzeta.wfengine.dao.TransitionDef;

public abstract class WorkflowDefEntity extends CommonEntity{
	private static final long serialVersionUID = 1L;
	private ArrayList<ActivityDef> activityDefs = new ArrayList<ActivityDef>();
	private ArrayList<TransitionDef> transitionDefs = new ArrayList<TransitionDef>();
	private ContextDef contextDef = null;
	
	public ArrayList<ActivityDef> getActivityDefs() {
		return activityDefs;
	}

	public void setActivityDefs(ArrayList<ActivityDef> activityDefs) {
		this.activityDefs = activityDefs;
	}

	public ArrayList<TransitionDef> getTransitionDefs() {
		return transitionDefs;
	}

	public void setTransitionDefs(ArrayList<TransitionDef> transitionDefs) {
		this.transitionDefs = transitionDefs;
	}

	public ContextDef getContextDef() {
		return contextDef;
	}

	public void setContextDef(ContextDef contextDef) {
		this.contextDef = contextDef;
	}
}
