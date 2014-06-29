package com.marzeta.wfengine.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.marzeta.wfengine.model.ActivityDefEntity;
import com.marzeta.wfengine.model.CommonEntity;
import com.marzeta.wfengine.dao.WorkflowDef;
import com.marzeta.wfengine.commons.IActivityDef;
import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.commons.LoggingUtil;
import com.marzeta.wfengine.commons.OKResult;
import javax.persistence.Entity;

@Entity
public class ActivityDef extends ActivityDefEntity implements IActivityDef {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(ActivityDefEntity.class.getName());

	public static final String STOP = "STOP";
	public static final String START = "START";

	public ActivityDef() {
		LoggingUtil.setupLogger(LOG);
	}

	public ActivityDef(WorkflowDef workflowDef, String name, boolean urgent) {
		this();
		setWorkflowDef(workflowDef);
		if (workflowDef != null) {
			workflowDef.getActivityDefs().add(this);
		}
		setName(name);
		setUrgent(urgent);
	}
	
	public ActivityDef(WorkflowDef workflowDef, String name) {
		this(workflowDef, name, true);
	}

	public IResult execute() throws Throwable {
		LOG.info("Processing activity " + this);
		return OKResult.OK;
	}
}
