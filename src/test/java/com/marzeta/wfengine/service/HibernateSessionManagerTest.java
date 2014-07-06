package com.marzeta.wfengine.service;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Test;

import com.marzeta.wfengine.model.ContextDef;

public class HibernateSessionManagerTest {
	@Test
	public void testPersistance() throws Exception {
		Session session = HibernateSessionManager.getSessionFactory().openSession();

		session.beginTransaction();
		ContextDef wd = new ContextDef();
		wd.setName("dummy");
		session.save(wd);
		session.getTransaction().commit();
		long id = wd.getId();

		wd = (ContextDef) session.get(ContextDef.class, id);
		assertTrue(wd != null);
	}
}
