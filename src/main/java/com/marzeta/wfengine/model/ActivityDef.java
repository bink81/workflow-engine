package com.marzeta.wfengine.model;

import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.commons.IActivityDef;
import com.marzeta.wfengine.commons.Result;
import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
public class ActivityDef extends EntityCommon implements IActivityDef {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(ActivityDef.class.getName());

	@NotNull
	public static final String STOP = "STOP";

	@NotNull
	public static final String START = "START";

	@NotNull
	public static ActivityDef DUMMY = new ActivityDef();

	@ManyToOne
	@NotNull
	private WorkflowDef workflowDef = WorkflowDef.DUMMY;

	private boolean urgent = false;

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	protected ActivityDef() {
	}

	public ActivityDef(@NotNull WorkflowDef workflowDef, @NotNull String name) {
		this(workflowDef, name, true);
	}

	public ActivityDef(@NotNull WorkflowDef workflowDef, @NotNull String name, boolean urgent) {
		super();
		this.workflowDef = workflowDef;
		setName(name);
		setUrgent(urgent);
	}

	public WorkflowDef getWorkflowDef() {
		return workflowDef;
	}

	@Override
	public Result execute() throws Throwable {
		LOG.info("Processing activity " + this);
		return Result.OK;
	}

	@Override
	public String toString() {
		return "ActivityDef [ " + super.toString() + "workflowDef=" + workflowDef + "urgent=" + urgent + "]";
	}
}
