package com.marzeta.wfengine.model;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.commons.OKResult;
import com.marzeta.wfengine.model.common.ActivityCommon;

public class Activity extends ActivityCommon {
	private final static Logger LOG = Logger.getLogger(Activity.class.getName());

	private static final long serialVersionUID = 1L;

	@NotNull
	private final Workflow workflow;

	private IResult result;

	public IResult getResult() {
		return result;
	}

	public void setResult(IResult result) {
		this.result = result;
	}

	@NotNull
	public Workflow getWorkflow() {
		return workflow;
	}

	public ActivityDef getActivityDef() {
		return activityDef;
	}

	@NotNull
	private final ActivityDef activityDef;

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
	public final IResult run() throws Throwable {
		checkMandatoryPreconditions();
		checkPreconditions();
		LOG.info(getId() + " -> Activity started: " + this);
		ActivityDef activityDef2 = getActivityDef();
		setResult(activityDef2.execute());
		if (getResult() == null) {
			LOG.warning("No result present, assigning result to default value: " + OKResult.OK);
			setResult(OKResult.OK);
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

	public boolean isStopActivity() {
		return getName().equalsIgnoreCase(ActivityDef.STOP);
	}
}
