package com.marzeta.wfengine.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransitionEntityTest {

	@Test
	public void testSetters() throws Exception {
		WorkflowDef wd = new WorkflowDef("createWorkflow", new ContextDef());
		ActivityDef activityDef = new ActivityDef(wd, "2");
		wd.addActivity(activityDef);
		Workflow workflow = new Workflow(wd);
		Activity activity = new Activity(activityDef, workflow);

		Transition transition = new Transition(workflow, activity, activity);
		transition.setDelay(1);
		transition.setName("asdf");

		assertEquals(activity, transition.getFromActivity());
		assertEquals(activity, transition.getToActivity());
		assertEquals(1, transition.getDelay());
	}
}
