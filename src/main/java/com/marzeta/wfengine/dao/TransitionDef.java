package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.commons.IResult;
import com.marzeta.wfengine.commons.OKResult;
import com.marzeta.wfengine.model.TransitionDefEntity;
import com.marzeta.wfengine.dao.WorkflowDef;
import javax.persistence.Entity;

@Entity
public class TransitionDef extends TransitionDefEntity {
	private static final long serialVersionUID = 1L;

	public TransitionDef() {}

	public TransitionDef(WorkflowDef workflowDef, ActivityDef fromActivityDef, ActivityDef toActivityDef) {
		this(workflowDef, fromActivityDef, toActivityDef, OKResult.OK);
	}

	public TransitionDef(WorkflowDef workflowDef, ActivityDef fromActivityDef, ActivityDef toActivityDef, IResult result) {
		setWorkflowDef(workflowDef);
		setFromActivityDef(fromActivityDef);
		setToActivityDef(toActivityDef);
		setResult(result);
	}
}
