package com.marzeta.wfengine.service;

import javax.validation.constraints.NotNull;

import org.hibernate.Session;

import com.marzeta.wfengine.dao.ContextDao;
import com.marzeta.wfengine.dao.ContextDaoJpa;
import com.marzeta.wfengine.model.Activity;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.Context;
import com.marzeta.wfengine.model.Workflow;
import com.marzeta.wfengine.model.WorkflowDef;

public class WorkflowService {

	private final ContextDao contextDao;

	public WorkflowService(Session session) {
		contextDao = new ContextDaoJpa();
		contextDao.setSession(session);
	}

	@NotNull
	public Workflow createWorkflow(@NotNull WorkflowDef wd) {
		Workflow wf = new Workflow(wd);
		ActivityDef startActivityDef = wd.getStartActivityDef();
		wf.getActivities().add(new Activity(startActivityDef, wf));
		Context context = new Context(wd.getContextDef());
		contextDao.create(context);
		wf.setContext(context);
		return wf;
	}
}
