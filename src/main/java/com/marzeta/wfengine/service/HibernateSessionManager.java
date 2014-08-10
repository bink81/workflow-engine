package com.marzeta.wfengine.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.marzeta.wfengine.model.Activity;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.Context;
import com.marzeta.wfengine.model.ContextDef;
import com.marzeta.wfengine.model.ContextObject;
import com.marzeta.wfengine.model.ContextObjectDef;
import com.marzeta.wfengine.model.Transition;
import com.marzeta.wfengine.model.TransitionDef;
import com.marzeta.wfengine.model.Workflow;
import com.marzeta.wfengine.model.WorkflowDef;

public class HibernateSessionManager {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new AnnotationConfiguration().configure().addAnnotatedClass(ContextDef.class)
					.addAnnotatedClass(ContextObjectDef.class).addAnnotatedClass(TransitionDef.class)
					.addAnnotatedClass(WorkflowDef.class).addAnnotatedClass(ActivityDef.class).addAnnotatedClass(Context.class)
					.addAnnotatedClass(ContextObject.class).addAnnotatedClass(Transition.class).addAnnotatedClass(Workflow.class)
					.addAnnotatedClass(Activity.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
