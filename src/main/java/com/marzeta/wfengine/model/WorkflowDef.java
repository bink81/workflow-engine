package com.marzeta.wfengine.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.commons.Result;
import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
public class WorkflowDef extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	public static final WorkflowDef DUMMY = new WorkflowDef();

	@OneToMany(mappedBy = "workflowDef")
	private Collection<ActivityDef> activityDefs = new ArrayList<ActivityDef>();

	@OneToMany(mappedBy = "workflowDef")
	private Collection<TransitionDef> transitionDefs = new ArrayList<TransitionDef>();

	@ManyToOne
	@NotNull
	private ContextDef contextDef = ContextDef.DUMMY;

	protected WorkflowDef() {
	}

	public WorkflowDef(@NotNull String name, @NotNull ContextDef contextDef) {
		this.contextDef = contextDef;
		setName(name);
		activityDefs.add(new ActivityDef(this, ActivityDef.START));
		activityDefs.add(new ActivityDef(this, ActivityDef.STOP));
	}

	public Collection<ActivityDef> getActivityDefs() {
		return activityDefs;
	}

	public void setActivityDefs(ArrayList<ActivityDef> activityDefs) {
		this.activityDefs = activityDefs;
	}

	public Collection<TransitionDef> getTransitionDefs() {
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
			@NotNull Result result) {
		getTransitionDefs().add(new TransitionDef(this, fromActivityDef, toActivityDef, result));
	}

	public void addActivity(@NotNull ActivityDef ativityDef) {
		getActivityDefs().add(ativityDef);
	}

	@Override
	public String toString() {
		return "WorkflowDef [" + super.toString() + ", contextDef=" + contextDef + "]";
	}
}
