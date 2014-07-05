package com.marzeta.wfengine.model;

import java.util.logging.Logger;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.IActivityDef;
import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.commons.OKResult;
import com.marzeta.wfengine.model.common.ActivityCommon;

public class ActivityDef extends ActivityCommon implements IActivityDef {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(ActivityDef.class.getName());

	public static final String STOP = "STOP";

	public static final String START = "START";

	@NotNull
	private final WorkflowDef workflowDef;

	public ActivityDef(@NotNull WorkflowDef workflowDef, String name) {
		this(workflowDef, name, true);
	}

	public ActivityDef(@NotNull WorkflowDef workflowDef, String name, boolean urgent) {
		super();
		this.workflowDef = workflowDef;
		setName(name);
		setUrgent(urgent);
	}

	public WorkflowDef getWorkflowDef() {
		return workflowDef;
	}

	@Override
	public IResult execute() throws Throwable {
		LOG.info("Processing activity " + this);
		return OKResult.OK;
	}

	@Override
	public String toString() {
		return "ActivityDef [ " + super.toString() + "workflowDef=" + workflowDef + "]";
	}
}