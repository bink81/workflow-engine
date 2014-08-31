package com.marzeta.wfengine.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marzeta.wfengine.service.CommonTest;
import com.marzeta.wfengine.service.WorkflowDefService;
import com.marzeta.wfengine.service.WorkflowService;

public class TransitionEntityTest extends CommonTest {
	@Test
	public void testSetters() throws Exception {
		WorkflowDef wd = new WorkflowDefService(getOrOpenSession()).createWorkflowDef();
		ActivityDef activityDef = new ActivityDef(wd, "2");
		wd.addActivity(activityDef);
		Workflow workflow = new WorkflowService(getOrOpenSession()).createWorkflow(wd);
		Activity activity = new Activity(activityDef, workflow);

		Transition transition = new Transition(workflow, activity, activity);
		transition.setDelay(1);
		transition.setName("asdf");

		assertEquals(activity, transition.getFromActivity());
		assertEquals(activity, transition.getToActivity());
		assertEquals(1, transition.getDelay());
	}
}
