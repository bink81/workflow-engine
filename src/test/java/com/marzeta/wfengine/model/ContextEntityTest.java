package com.marzeta.wfengine.model;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import com.marzeta.wfengine.service.Context;

public class ContextEntityTest {

	@Test
	public void testSetContextObjects() throws Exception {
		Context c = new Context();
		
		HashMap<String, Object> contextObjects = new HashMap<String, Object>();
		c.setContextObjects(contextObjects );
		
		assertEquals(contextObjects, c.getContextObjects());
	}

}
