package com.marzeta.wfengine.dao;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.model.WorkflowDefEntity;
import com.marzeta.wfengine.service.Workflow;

public class WorkflowDef extends WorkflowDefEntity {
	private static final long serialVersionUID = 1L;

	public WorkflowDef() {
	}

	public WorkflowDef(String name, ContextDef contextDef) {
		setName(name);
		setContextDef(contextDef);
	}

	public Workflow startWorkflow() throws ConfigurationException {
		return new Workflow(this);
	}

	public @NotNull
	ActivityDef getStartActivityDef() throws ConfigurationException {
		for (ActivityDef activityDef : getActivityDefs()) {
			if (activityDef.getName().equalsIgnoreCase(ActivityDef.START)) {
				return activityDef;
			}
		}
		throw new ConfigurationException("Cannot find START activity in " + this);
	}

	public void createLink(@NotNull ActivityDef fromActivityDef, @NotNull ActivityDef toActivityDef) {
		getTransitionDefs().add(new TransitionDef(this, fromActivityDef, toActivityDef));
	}

	public void createLink(@NotNull ActivityDef fromActivityDef, @NotNull ActivityDef toActivityDef,
			@NotNull IResult result) {
		getTransitionDefs().add(new TransitionDef(this, fromActivityDef, toActivityDef, result));
	}
}
