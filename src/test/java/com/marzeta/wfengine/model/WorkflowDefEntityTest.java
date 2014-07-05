package com.marzeta.wfengine.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class WorkflowDefEntityTest {

	@Test
	public void testInitialActivityDefs() throws Exception {
		WorkflowDef workflowDef = new WorkflowDef("testInitialActivityDefs", new ContextDef());
		printActivities(workflowDef);
		assertTrue(workflowDef.getActivityDefs().size() == 2);
		assertTrue(workflowDef.getTransitionDefs().isEmpty());
	}

	private void printActivities(WorkflowDef workflowDef) {
		System.err.println(workflowDef);
		for (ActivityDef a : workflowDef.getActivityDefs()) {
			System.err.println(a);
		}
		System.err.println("");
	}

	@Test
	public void testListSetters() throws Exception {
		WorkflowDef workflowDef = new WorkflowDef("testListSetters", new ContextDef());

		ArrayList<ActivityDef> activityDefs = new ArrayList<ActivityDef>();
		workflowDef.setActivityDefs(activityDefs);
		ArrayList<TransitionDef> transitionDefs = new ArrayList<TransitionDef>();
		workflowDef.setTransitionDefs(transitionDefs);

		assertEquals(activityDefs, workflowDef.getActivityDefs());
		assertEquals(transitionDefs, workflowDef.getTransitionDefs());
	}

	@Test
	public void testAddingToDefs() throws Exception {
		WorkflowDef workflowDef = new WorkflowDef("testAddingToDefs", new ContextDef());

		ActivityDef a1 = new ActivityDef(workflowDef, "1");
		workflowDef.addActivity(a1);
		ActivityDef a2 = new ActivityDef(workflowDef, "2");
		workflowDef.addActivity(a2);
		printActivities(workflowDef);

		assertEquals(4, workflowDef.getActivityDefs().size());

		workflowDef.getTransitionDefs().add(new TransitionDef(workflowDef, a1, a2));
		assertEquals(1, workflowDef.getTransitionDefs().size());
	}
}
