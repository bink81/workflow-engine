package com.marzeta.wfengine.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marzeta.wfengine.dao.ContextDefDao;
import com.marzeta.wfengine.dao.ContextDefDaoJpa;
import com.marzeta.wfengine.model.ContextDef;

public class HibernateSessionManagerTest {
	@Test
	public void testPersistance() throws Exception {
		ContextDef cd = new ContextDef();
		cd.setName("dummy");
		ContextDefDao dao = new ContextDefDaoJpa();

		long id = dao.save(cd);
		cd = dao.findById(id);

		assertTrue(cd != null);
	}
}
