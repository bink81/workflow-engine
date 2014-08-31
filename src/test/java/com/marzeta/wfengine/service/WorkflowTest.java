package com.marzeta.wfengine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.dao.WorkflowDao;
import com.marzeta.wfengine.dao.WorkflowDaoJpa;
import com.marzeta.wfengine.model.Activity;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.Transition;
import com.marzeta.wfengine.model.Workflow;
import com.marzeta.wfengine.model.WorkflowDef;

public class WorkflowTest extends CommonTest {
	WorkflowDao workflowDao;

	WorkflowDefService workflowDefService;

	@Before
	public void setUp() throws Exception {
		Session session = getOrOpenSession();
		workflowDao = new WorkflowDaoJpa();
		workflowDao.setSession(session);
		workflowDefService = new WorkflowDefService(session);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingActivity() throws Exception {
		WorkflowDef wd = workflowDefService.createWorkflowDef();
		ActivityDef activityDef = new ActivityDef(wd, "2");
		workflowDefService.createActivityDef(activityDef);
		wd.addActivity(activityDef);
		long workflowDefId = workflowDefService.updateWorkflowDef(wd).getId();
		Workflow workflow = new WorkflowService(getOrOpenSession()).createWorkflow(wd);
		long workflowId = workflowDao.create(workflow);

		Activity activity = workflow.getActivityFor(activityDef);

		assertTrue(activity.getActivityDef().equals(activityDef));
		assertTrue(workflow.getWorkflowDef().getId() == workflowDefId);
		assertTrue(workflow.getId() == workflowId);
	}

	@Test
	public void testAnotherMissingStartActivity() throws Exception {
		boolean condition = false;
		WorkflowDef wd = workflowDefService.createWorkflowDef();
		Workflow workflow = new WorkflowService(getOrOpenSession()).createWorkflow(wd);
		ActivityDef activityDef = new ActivityDef(wd, "123");
		wd.addActivity(activityDef);
		try {
			workflow.getActivityFor(activityDef);
		} catch (ConfigurationException e) {
			condition = true;
		}
		assertTrue(condition);
	}

	@Test
	public void testSetters() throws Exception {
		WorkflowDef wd = workflowDefService.createWorkflowDef();
		Workflow workflow = new WorkflowService(getOrOpenSession()).createWorkflow(wd);

		ArrayList<Activity> activities = new ArrayList<Activity>();
		workflow.setActivities(activities);

		ArrayList<Transition> transitions = new ArrayList<Transition>();
		workflow.setTransitions(transitions);

		assertEquals(activities, workflow.getActivities());
		assertEquals(transitions, workflow.getTransitions());
	}
}
