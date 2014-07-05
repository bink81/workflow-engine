package com.marzeta.wfengine.model;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

public class ContextEntityTest {

	private static final String DUMMY_KEY = "DUMMY_KEY";

	@Test
	public void testSetContextObjects() throws Exception {
		Context c = new Context(new ContextDef());

		HashMap<String, Object> contextObjects = c.getContextObjects();
		contextObjects.put(DUMMY_KEY, null);

		assertTrue(c.getContextObjects().containsKey(DUMMY_KEY));
	}
}
