package com.marzeta.wfengine.service;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.dao.TransitionDef;
import com.marzeta.wfengine.model.TransitionEntity;
import javax.persistence.Entity;


@Entity
public class Transition extends TransitionEntity{
	private static final long serialVersionUID = 1L;

	public Transition() {}
	
	public Transition(Workflow workflow, TransitionDef transitionDef) throws ConfigurationException {
		setWorkflow(workflow);
		setTransitionDef(transitionDef);
		setFromActivity(workflow.getActivityFor(transitionDef.getFromActivityDef()));
		setToActivity(workflow.getActivityFor(transitionDef.getToActivityDef()));
		setResult(transitionDef.getResult());
	}
}
