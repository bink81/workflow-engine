package com.marzeta.wfengine.service;

import javax.validation.constraints.NotNull;

import org.hibernate.Session;

import com.marzeta.wfengine.dao.ActivityDefDao;
import com.marzeta.wfengine.dao.ActivityDefDaoJpa;
import com.marzeta.wfengine.dao.ContextDefDao;
import com.marzeta.wfengine.dao.ContextDefDaoJpa;
import com.marzeta.wfengine.dao.WorkflowDefDao;
import com.marzeta.wfengine.dao.WorkflowDefDaoJpa;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.ContextDef;
import com.marzeta.wfengine.model.WorkflowDef;

public class WorkflowDefService {
	private final WorkflowDefDao workflowDefDao;

	private final ContextDefDao contextDefDao;

	private final ActivityDefDao activityDefDao;

	public WorkflowDefService(Session session) {
		workflowDefDao = new WorkflowDefDaoJpa();
		workflowDefDao.setSession(session);
		contextDefDao = new ContextDefDaoJpa();
		contextDefDao.setSession(session);
		activityDefDao = new ActivityDefDaoJpa();
		activityDefDao.setSession(session);
	}

	@NotNull
	public WorkflowDef createWorkflowDef() {
		ContextDef cd = new ContextDef();
		contextDefDao.create(cd);
		WorkflowDef wd = new WorkflowDef("createWorkflow", cd);
		workflowDefDao.create(wd);
		return wd;
	}

	public WorkflowDef updateWorkflowDef(WorkflowDef wd) {
		return workflowDefDao.update(wd);
	}

	public void createActivityDef(ActivityDef activityDef) {
		activityDefDao.create(activityDef);
	}
}
