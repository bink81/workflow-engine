package com.marzeta.wfengine.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Properties;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.marzeta.wfengine.dao.ErroneousActivityDef;
import com.marzeta.wfengine.dao.WorkActivityDef;
import com.marzeta.wfengine.model.Activity;
import com.marzeta.wfengine.model.ActivityDef;
import com.marzeta.wfengine.model.ContextDef;
import com.marzeta.wfengine.model.Workflow;
import com.marzeta.wfengine.model.WorkflowDef;

public class ActivityEngineTest extends CommonTest {
	WorkActivityDef workActivityDef;

	Session session;

	@Before
	public void setUp() throws Exception {
		WorkflowDef wd = new WorkflowDef("setUp", new ContextDef());
		workActivityDef = new WorkActivityDef(wd, "setUp");
		session = getOrOpenSession();
	}

	// ------------------------------------------------------------------------------------------------------------
	@Test
	public void testRunWithNoActivities() throws Exception {
		ActivityEngineWithNoActivities engine = new ActivityEngineWithNoActivities("ActivityEngineWithNoActivities");
		engine.run();

		assertEquals(1, engine.getInternalDelay());
	}

	@Test
	public void testRunWithWithNoPropertiesFile() throws Exception {
		ActivityEngineWithNoActivities engine = new ActivityEngineWithNoActivities("testRunWithWithNoPropertiesFile");
		engine.setProperties(new Properties());
		engine.setInternalDelay(0);
		engine.run();

		assertEquals(0, engine.getInternalDelay());
	}

	private class ActivityEngineWithNoActivities extends ActivityEngine {
		public ActivityEngineWithNoActivities(String name) {
			super(name);
		}

		@Override
		public ArrayList<Activity> getActivities() {
			return null;
		}
	}

	// ------------------------------------------------------------------------------------------------------------
	// @Test
	// public void testRunWithSingleActivities() throws Exception {
	// ActivityEngineWithSingleActivities engine = new
	// ActivityEngineWithSingleActivities();
	// engine.run();
	//
	// assertEquals(3, workActivityDef.counter);
	// assertEquals(1, engine.getInternalDelay());
	// }
	//
	// private class ActivityEngineWithSingleActivities extends ActivityEngine {
	// @Override
	// public ArrayList<Activity> getActivities() {
	// ArrayList<Activity> activities = new ArrayList<Activity>();
	// activities.add(new TestActivity(workActivityDef));
	// activities.add(new TestActivity(workActivityDef));
	// activities.add(new TestActivity(workActivityDef));
	// return activities;
	// }
	// }
	//
	// private class TestActivity extends Activity {
	// public TestActivity(ActivityDef activityDef) {
	// super(activityDef);
	// }
	// }
	//
	// private class WorkActivityDef extends ActivityDef {
	// private static final long serialVersionUID = 1L;
	// int counter = 0;
	//
	// @Override
	// public IResult execute() {
	// counter++;
	// System.out.println("Running " + counter);
	// return Result.DONE;
	// }
	// }
	//
	// public enum Result implements IResult {
	// DONE, ERROR
	// }

	// ------------------------------------------------------------------------------------------------------------
	@Test
	public void testRunWithWorkflow() throws Exception {
		TestWorkflowEngine engine = new TestWorkflowEngine(getOrOpenSession());
		engine.run();

		assertEquals(1, engine.getInternalDelay());
	}

	@Test()
	public void testRunWithException() throws Exception {
		ActivityEngineWithException engine = new ActivityEngineWithException("testRunWithException");
		engine.run();
	}

	private class ActivityEngineWithException extends ActivityEngine {

		public ActivityEngineWithException(String name) {
			super(name);
		}

		@Override
		public ArrayList<Activity> getActivities() {
			ArrayList<Activity> arrayList = new ArrayList<Activity>();
			WorkflowDef workflowDef = new WorkflowDefService(session).createWorkflowDef();
			workflowDef.addActivity(new ActivityDef(workflowDef, "start"));
			Workflow workflow = null;
			workflow = new WorkflowService(session).createWorkflow(workflowDef);
			ErroneousActivityDef activityDef = new ErroneousActivityDef(workflowDef, "ErroneousActivityDef");
			workflowDef.addActivity(activityDef);
			Activity activity = new Activity(activityDef, workflow);
			arrayList.add(activity);
			return arrayList;
		}
	}
}
