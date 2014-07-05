package com.marzeta.wfengine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.model.Activity;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.ContextDef;
import com.marzeta.wfengine.model.Transition;
import com.marzeta.wfengine.model.Workflow;
import com.marzeta.wfengine.model.WorkflowDef;
import com.marzeta.wfengine.utils.TestUtils;

public class WorkflowTest {

	@Test(expected = ConfigurationException.class)
	public void testMissingActivity() throws Exception {
		WorkflowDef wd = new WorkflowDef("createWorkflow", new ContextDef());
		ActivityDef activityDef = new ActivityDef(wd, "2");
		wd.addActivity(activityDef);
		Workflow workflow = new Workflow(wd);

		Activity activity = workflow.getActivityFor(activityDef);

		assertTrue(activity.getActivityDef().equals(activityDef));
	}

	@Test
	public void testAnotherMissingStartActivity() throws Exception {
		boolean condition = false;
		WorkflowDef wd = new WorkflowDef("createWorkflow", new ContextDef());
		Workflow workflow = new Workflow(wd);
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
		Workflow workflow = TestUtils.createWorkflow();

		ArrayList<Activity> activities = new ArrayList<Activity>();
		workflow.setActivities(activities);

		ArrayList<Transition> transitions = new ArrayList<Transition>();
		workflow.setTransitions(transitions);

		assertEquals(activities, workflow.getActivities());
		assertEquals(transitions, workflow.getTransitions());
	}
}
