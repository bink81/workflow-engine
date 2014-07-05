package com.marzeta.wfengine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.dao.ActivityDef;
import com.marzeta.wfengine.utils.TestUtils;

public class WorkflowTest {

	@Test(expected = ConfigurationException.class)
	public void testMissingStartActivity() throws Exception {
		Workflow workflow = TestUtils.createWorkflow();
		ActivityDef activityDef = new ActivityDef();
		workflow.getActivityFor(activityDef);
		fail("getActivityFor should've thrown an exception!");
	}

	@Test
	public void testAnotherMissingStartActivity() throws Exception {
		boolean condition = false;
		Workflow workflow = TestUtils.createWorkflow();
		ActivityDef activityDef = new ActivityDef();
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
