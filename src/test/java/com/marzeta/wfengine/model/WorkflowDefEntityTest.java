package com.marzeta.wfengine.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.marzeta.wfengine.dao.ActivityDef;
import com.marzeta.wfengine.dao.TransitionDef;
import com.marzeta.wfengine.dao.WorkflowDef;

public class WorkflowDefEntityTest {

	@Test
	public void testInitialActivityDefs() throws Exception {
		WorkflowDef workflowDefEntity = new WorkflowDef();

		assertTrue(workflowDefEntity.getActivityDefs().isEmpty());
		assertTrue(workflowDefEntity.getTransitionDefs().isEmpty());
	}

	@Test
	public void testListSetters() throws Exception {
		WorkflowDef workflowDefEntity = new WorkflowDef();
		
		ArrayList<ActivityDef> activityDefs = new ArrayList<ActivityDef>();
		workflowDefEntity.setActivityDefs(activityDefs);
		ArrayList<TransitionDef> transitionDefs = new ArrayList<TransitionDef>();
		workflowDefEntity.setTransitionDefs(transitionDefs);
		
		assertEquals(activityDefs, workflowDefEntity.getActivityDefs());
		assertEquals(transitionDefs, workflowDefEntity.getTransitionDefs());
	}
	
	@Test
	public void testAddingToDefs() throws Exception {
		WorkflowDef workflowDef = new WorkflowDef();
		
		new ActivityDef(workflowDef, "asdf");
		assertEquals(1, workflowDef.getActivityDefs().size());

		workflowDef.getTransitionDefs().add(new TransitionDef());
		assertEquals(1, workflowDef.getTransitionDefs().size());
	}
}
