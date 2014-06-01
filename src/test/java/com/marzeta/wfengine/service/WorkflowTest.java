package com.marzeta.wfengine.service;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.dao.ActivityDef;

public class WorkflowTest {

	@Test(expected = ConfigurationException.class)
	public void testMissingStartActivity() throws Exception {
		Workflow workflow = new Workflow();
		ActivityDef activityDef = new ActivityDef();
		workflow.getActivityFor(activityDef);
		fail("getActivityFor should've thrown an exception!");
	}
	
	@Test
	public void testAnotherMissingStartActivity() throws Exception {
		boolean condition = false;
		Workflow workflow = new Workflow();
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
		Workflow workflow = new Workflow();
		
		ArrayList<Activity> activities = new ArrayList<Activity>();
		workflow.setActivities(activities);
		
		ArrayList<Transition> transitions = new ArrayList<Transition>();
		workflow.setTransitions(transitions);
		
		assertEquals(activities, workflow.getActivities());
		assertEquals(transitions, workflow.getTransitions());
	}
}
