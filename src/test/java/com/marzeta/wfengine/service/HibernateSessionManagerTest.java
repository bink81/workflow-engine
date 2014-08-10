package com.marzeta.wfengine.service;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Test;

import com.marzeta.wfengine.dao.ContextDefDao;
import com.marzeta.wfengine.dao.ContextDefDaoJpa;
import com.marzeta.wfengine.model.ContextDef;

public class HibernateSessionManagerTest {
	@Test
	public void testPersistWithDao() throws Exception {
		ContextDef contextDef = createDummyContextDef();
		ContextDefDao dao = new ContextDefDaoJpa();

		long id = dao.create(contextDef);
		ContextDef newContextDef = dao.retrieveById(id);

		assertTrue(newContextDef != null);
		Assert.assertEquals(newContextDef, contextDef);
	}

	@Test
	public void testUpdateWithDao() throws Exception {
		ContextDef contextDef = createDummyContextDef();
		ContextDefDao dao = new ContextDefDaoJpa();

		long id = dao.create(contextDef);
		ContextDef newContextDef = dao.retrieveById(id);
		newContextDef.setName("new name");

		assertTrue(newContextDef != null);
		Assert.assertNotSame(newContextDef, contextDef);
	}

	@Test
	public void testPersistWithRepository() throws Exception {
		ContextDef contextDef = createDummyContextDef();
		Repository dao = new Repository();

		long id = dao.create(contextDef);
		ContextDef newContextDef = dao.retrieveById(ContextDef.class, id);

		assertTrue(newContextDef != null);
		Assert.assertEquals(newContextDef, contextDef);
	}

	@Test
	public void testUpdateWithRepository() throws Exception {
		ContextDef contextDef = createDummyContextDef();
		Repository dao = new Repository();

		long id = dao.create(contextDef);
		ContextDef newContextDef = dao.retrieveById(ContextDef.class, id);
		newContextDef.setName("new name");

		assertTrue(newContextDef != null);
		Assert.assertNotSame(newContextDef, contextDef);
	}

	private ContextDef createDummyContextDef() {
		ContextDef contextDef = new ContextDef();
		contextDef.setName("dummy");
		return contextDef;
	}
}
