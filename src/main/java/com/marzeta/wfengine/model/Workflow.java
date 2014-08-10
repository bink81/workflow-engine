package com.marzeta.wfengine.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
public class Workflow extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	public static final Workflow DUMMY = new Workflow();

	@OneToMany(mappedBy = "workflow")
	private Collection<Activity> activities = new ArrayList<Activity>();

	@OneToMany(mappedBy = "workflow")
	private Collection<Transition> transitions = new ArrayList<Transition>();

	@ManyToOne
	@NotNull
	private WorkflowDef workflowDef = WorkflowDef.DUMMY;

	@ManyToOne
	private Context context = null;

	protected Workflow() {
	}

	public WorkflowDef getWorkflowDef() {
		return workflowDef;
	}

	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

	public Collection<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(Collection<Transition> transitions) {
		this.transitions = transitions;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Workflow(@NotNull WorkflowDef workflowDef) {
		this.workflowDef = workflowDef;
		setName(workflowDef.getName());
		ActivityDef startActivityDef = workflowDef.getStartActivityDef();
		getActivities().add(new Activity(startActivityDef, this));
		setContext(new Context(workflowDef.getContextDef()));
	}

	public Activity getNextActivity() {
		for (Activity activity : getActivities()) {
			if (activity.getResult() == null) {
				return activity;
			}
		}
		return null;
	}

	public ArrayList<Activity> createNextActivity(Activity fromActivity) {
		ArrayList<Activity> newActivities = new ArrayList<Activity>();
		WorkflowDef wd = getWorkflowDef();
		for (TransitionDef transitionDef : wd.getTransitionDefs()) {
			if (transitionDef.getFromActivityDef().equals(fromActivity.getActivityDef())
					&& transitionDef.getResult().equals(fromActivity.getResult())) {
				Activity toActivity = new Activity(transitionDef.getToActivityDef(), fromActivity.getWorkflow());
				getActivities().add(toActivity);
				getTransitions().add(new Transition(this, fromActivity, toActivity));
				newActivities.add(toActivity);
				break;
			}
		}
		if (newActivities.isEmpty() && !fromActivity.isStop()) {
			throw new ConfigurationException("Next activity cannot be found for " + fromActivity + " in " + this);
		}
		return newActivities;
	}

	@NotNull
	public Activity getActivityFor(ActivityDef activityDef) {
		for (Activity activity : getActivities()) {
			if (activity.getActivityDef() == activityDef) {
				return activity;
			}
		}
		throw new ConfigurationException("No activity found for activityDef" + activityDef + " in " + this);
	}

	@Override
	public String toString() {
		return "Workflow [ " + super.toString() + ", workflowDef=" + workflowDef + ", context=" + context + "]";
	}
}
