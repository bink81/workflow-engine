package com.marzeta.wfengine.model;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.marzeta.wfengine.dao.ActivityDef;

public class CommonEntityTest {

	@Test
	public void testDifferent() throws Exception {
		ActivityDef activityDef1 = new ActivityDef();
		ActivityDef activityDef2 = new ActivityDef();
		Set<ActivityDef> hashSet = new java.util.HashSet<ActivityDef>();
		hashSet.add(activityDef1);

		Assert.assertFalse(activityDef1.equals(activityDef2));
		Assert.assertTrue(hashSet.contains(activityDef1));
		Assert.assertFalse(hashSet.contains(activityDef2));
	}

	@Test
	public void testSame() throws Exception {
		ActivityDef activityDef1 = new ActivityDef();
		ActivityDef activityDef2 = new ActivityDef();
		activityDef2.setId(activityDef1.getId());
		Set<ActivityDef> hashSet = new java.util.HashSet<ActivityDef>();
		hashSet.add(activityDef1);

		Assert.assertTrue(activityDef1.equals(activityDef2));
		Assert.assertTrue(hashSet.contains(activityDef1));
		Assert.assertTrue(hashSet.contains(activityDef2));
	}

}
