package com.marzeta.wfengine.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marzeta.wfengine.service.Activity;
import com.marzeta.wfengine.service.Transition;

public class TransitionEntityTest {

	@Test
	public void testInitial() throws Exception {
		Transition transition = new Transition();
		
		assertTrue(transition.getDelay() == 0);
		assertTrue(transition.getFromActivity() == null);
		assertTrue(transition.getToActivity() == null);
		assertTrue(transition.getWorkflow() == null);
		assertTrue(transition.getResult() == null);
	}

	@Test
	public void testSetters() throws Exception {
		Transition transition = new Transition();
		Activity activity = new Activity();

		transition.setFromActivity(activity);
		transition.setToActivity(activity);
		transition.setDelay(1);
		transition.setName("asdf");
				
		assertEquals(activity, transition.getFromActivity());
		assertEquals(activity, transition.getToActivity());
		assertEquals(1, transition.getDelay());
		assertEquals("Transition,name=asdf-null", transition.toString());
	}

}
