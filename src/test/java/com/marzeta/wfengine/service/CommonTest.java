package com.marzeta.wfengine.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class CommonTest {
	protected Session getOrOpenSession() {
		Session currentSession;
		try {
			currentSession = HibernateSessionManager.getSessionFactory().getCurrentSession();
		} catch (HibernateException e) {
			currentSession = HibernateSessionManager.getSessionFactory().openSession();
			System.err.println("-Created session: " + currentSession);
		}
		System.err.println("-- " + currentSession);
		return currentSession;
	}
}
