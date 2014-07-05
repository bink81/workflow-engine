package com.marzeta.wfengine.model;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class CommonEntityTest {

	@Test
	public void testDifferent() throws Exception {
		WorkflowDef wd = new WorkflowDef("testDifferent", new ContextDef());
		ActivityDef activityDef1 = new ActivityDef(wd, null);
		ActivityDef activityDef2 = new ActivityDef(wd, null);
		Set<ActivityDef> hashSet = new java.util.HashSet<ActivityDef>();
		hashSet.add(activityDef1);

		Assert.assertFalse(activityDef1.equals(activityDef2));
		Assert.assertTrue(hashSet.contains(activityDef1));
		Assert.assertFalse(hashSet.contains(activityDef2));
	}

	@Test
	public void testSame() throws Exception {
		WorkflowDef wd = new WorkflowDef("testSame", new ContextDef());
		ActivityDef activityDef1 = new ActivityDef(wd, null);
		ActivityDef activityDef2 = new ActivityDef(wd, null);
		activityDef2.setId(activityDef1.getId());
		Set<ActivityDef> hashSet = new java.util.HashSet<ActivityDef>();
		hashSet.add(activityDef1);

		Assert.assertTrue(activityDef1.equals(activityDef2));
		Assert.assertTrue(hashSet.contains(activityDef1));
		Assert.assertTrue(hashSet.contains(activityDef2));
	}

}
