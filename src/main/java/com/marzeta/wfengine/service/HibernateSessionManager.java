package com.marzeta.wfengine.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.marzeta.wfengine.model.ContextDef;
import com.marzeta.wfengine.model.ContextObjectDef;

public class HibernateSessionManager {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new AnnotationConfiguration().configure().addAnnotatedClass(ContextDef.class)
					.addAnnotatedClass(ContextObjectDef.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
