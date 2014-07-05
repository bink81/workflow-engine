package com.marzeta.wfengine.dao;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.model.CommonEntity;
import com.marzeta.wfengine.service.Workflow;

public class WorkflowDef extends CommonEntity {
	private static final long serialVersionUID = 1L;

	private ArrayList<ActivityDef> activityDefs = new ArrayList<ActivityDef>();

	private ArrayList<TransitionDef> transitionDefs = new ArrayList<TransitionDef>();

	@NotNull
	private ContextDef contextDef;

	public WorkflowDef(String name, @NotNull ContextDef contextDef) {
		this.contextDef = contextDef;
		setName(name);
		activityDefs.add(new ActivityDef(this, ActivityDef.START));
		activityDefs.add(new ActivityDef(this, ActivityDef.STOP));
	}

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

	@NotNull
	public ContextDef getContextDef() {
		return contextDef;
	}

	public void setContextDef(@NotNull ContextDef contextDef) {
		this.contextDef = contextDef;
	}

	public Workflow startWorkflow() {
		return new Workflow(this);
	}

	public @NotNull
	ActivityDef getStartActivityDef() {
		for (ActivityDef activityDef : getActivityDefs()) {
			if (activityDef.getName().equalsIgnoreCase(ActivityDef.START)) {
				return activityDef;
			}
		}
		throw new ConfigurationException("Cannot find START activity in " + this);
	}

	public @NotNull
	ActivityDef getStopActivityDef() {
		for (ActivityDef activityDef : getActivityDefs()) {
			if (activityDef.getName().equalsIgnoreCase(ActivityDef.STOP)) {
				return activityDef;
			}
		}
		throw new ConfigurationException("Cannot find STOP activity in " + this);
	}

	public void createLink(@NotNull ActivityDef fromActivityDef, @NotNull ActivityDef toActivityDef) {
		getTransitionDefs().add(new TransitionDef(this, fromActivityDef, toActivityDef));
	}

	public void createLink(@NotNull ActivityDef fromActivityDef, @NotNull ActivityDef toActivityDef,
			@NotNull IResult result) {
		getTransitionDefs().add(new TransitionDef(this, fromActivityDef, toActivityDef, result));
	}

	public void addActivity(@NotNull ActivityDef ativityDef) {
		getActivityDefs().add(ativityDef);
	}
}
