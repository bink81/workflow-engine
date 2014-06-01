package com.marzeta.wfengine.service;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.marzeta.wfengine.commons.ConfigurationException;
import com.marzeta.wfengine.dao.ActivityDef;
import com.marzeta.wfengine.dao.ContextDef;
import com.marzeta.wfengine.dao.ErroneousActivityDef;
import com.marzeta.wfengine.dao.WorkActivityDef;
import com.marzeta.wfengine.dao.WorkflowDef;

public class ActivityEngineTest {
	WorkActivityDef workActivityDef;

	@Before
	public void setUp() throws Exception {
		workActivityDef = new WorkActivityDef();
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
		private static final long serialVersionUID = 1L;

		public ActivityEngineWithNoActivities(String name){
			super(name);
		}
		
		@Override
		public ArrayList<Activity> getActivities() {
			return null;
		}
	}

	// ------------------------------------------------------------------------------------------------------------
//	@Test
//	public void testRunWithSingleActivities() throws Exception {
		// ActivityEngineWithSingleActivities engine = new
		// ActivityEngineWithSingleActivities();
		// engine.run();
		//
		// assertEquals(3, workActivityDef.counter);
		// assertEquals(1, engine.getInternalDelay());
//	}
//
//	private class ActivityEngineWithSingleActivities extends ActivityEngine {
//		@Override
//		public ArrayList<Activity> getActivities() {
//			ArrayList<Activity> activities = new ArrayList<Activity>();
//			activities.add(new TestActivity(workActivityDef));
//			activities.add(new TestActivity(workActivityDef));
//			activities.add(new TestActivity(workActivityDef));
//			return activities;
//		}
//	}
//
//	private class TestActivity extends Activity {
//		public TestActivity(ActivityDef activityDef) {
//			super(activityDef);
//		}
//	}
//
//	private class WorkActivityDef extends ActivityDef {
//		private static final long serialVersionUID = 1L;
//		int counter = 0;
//
//		@Override
//		public IResult execute() {
//			counter++;
//			System.out.println("Running " + counter);
//			return OKResult.DONE;
//		}
//	}
//
//	public enum OKResult implements IResult {
//		DONE, ERROR
//	}

	// ------------------------------------------------------------------------------------------------------------
	@Test
	public void testRunWithWorkflow() throws Exception {
		TestWorkflowEngine engine = new TestWorkflowEngine();
		engine.run();

		assertEquals(1, engine.getInternalDelay());
	}
	
	@Test()
	public void testRunWithException() throws Exception {
		ActivityEngineWithException engine = new ActivityEngineWithException("testRunWithException");
		engine.run();
	}

	private class ActivityEngineWithException extends ActivityEngine {
		private static final long serialVersionUID = 1L;

		public ActivityEngineWithException(String name){
			super(name);
		}
		
		@Override
		public ArrayList<Activity> getActivities() {
			ArrayList<Activity> arrayList = new ArrayList<Activity>();
			ContextDef contextDef = new ContextDef();
			WorkflowDef workflowDef = new WorkflowDef("ErroneousWorkflowDef", contextDef );
			new ActivityDef(workflowDef, "start");
			Workflow workflow = null;
			try {
				workflow = new Workflow(workflowDef);
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
			ErroneousActivityDef activityDef = new ErroneousActivityDef(workflowDef , "ErroneousActivityDef");
			Activity activity = new Activity(activityDef, workflow);
			arrayList.add(activity );
			return arrayList;
		}
	}
}
