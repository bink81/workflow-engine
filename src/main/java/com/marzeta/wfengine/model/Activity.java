package com.marzeta.wfengine.model;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.Result;
import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
public class Activity extends EntityCommon {
	private final static Logger LOG = Logger.getLogger(Activity.class.getName());

	private static final long serialVersionUID = 1L;

	@NotNull
	public static final Activity DUMMY = new Activity();

	@ManyToOne
	@NotNull
	private Workflow workflow = Workflow.DUMMY;

	private Result result;

	@ManyToOne
	@NotNull
	private ActivityDef activityDef = ActivityDef.DUMMY;

	private boolean urgent = false;

	protected Activity() {
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@NotNull
	public Workflow getWorkflow() {
		return workflow;
	}

	public ActivityDef getActivityDef() {
		return activityDef;
	}

	public Activity(@NotNull ActivityDef activityDef, @NotNull Workflow workflow) {
		super();
		this.activityDef = activityDef;
		this.workflow = workflow;
		setUrgent(activityDef.isUrgent());
		setName(activityDef.getName());
	}

	private void checkMandatoryPreconditions() throws Exception {
	}

	public void checkPreconditions() {
		LOG.info("No pre-conditions exist for " + this);
	}

	public void checkPostconditions() {
		LOG.info("No post-conditions exist for " + this);
	}

	private void checkMandatoryPostconditions() {
	}

	// ------------------------------------------------------------
	// main method
	public final Result run() throws Throwable {
		checkMandatoryPreconditions();
		checkPreconditions();
		LOG.info(getId() + " -> Activity started: " + this);
		ActivityDef activityDef2 = getActivityDef();
		setResult(activityDef2.execute());
		if (getResult() == null) {
			LOG.warning("No result present, assigning result to default value: " + Result.OK);
			setResult(Result.OK);
		}
		LOG.info(getId() + " -> Finished activity: " + this);
		checkPostconditions();
		checkMandatoryPostconditions();
		ArrayList<Activity> newActivities = getWorkflow().createNextActivity(this);
		for (Activity activity : newActivities) {
			if (activity.isUrgent()) {
				activity.run();
			}
		}
		return getResult();
	}

	public boolean isStop() {
		return getName().equalsIgnoreCase(ActivityDef.STOP);
	}

	@Override
	public String toString() {
		return "Activity [ " + super.toString() + "workflow=" + workflow + ", result=" + result + ", activityDef="
				+ activityDef + "]";
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
}
