package com.marzeta.wfengine.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.marzeta.wfengine.commons.LoggingUtil;
import com.marzeta.wfengine.model.Activity;

public abstract class ActivityEngine extends EngineEntity {
	private static final long serialVersionUID = 1L;
	private static final String PROP_FILE = "properties.txt";
	public static final String EXCEPTION_TEST_TEXT = "Just testing exception handling...";
	private final static Logger LOG = Logger.getLogger(ActivityEngine.class.getName());

	public ActivityEngine() {
		this("Default");
	}

	public ActivityEngine(String name) {
		this.setName(name);
		readPropertiesFile();
		LoggingUtil.setupLogger(LOG);
	}
	
	public void run() {
		LOG.info("Starting engine '" + getName() + "'...");
		ArrayList<Activity> queue = getActivities();
		process(queue);
		LOG.info("Stoping engine '" + getName() + "'...\n");
	}

	private void process(ArrayList<Activity> activities) {
		if (activities == null) {
			LOG.warning("No activities found, aborting...");
			return;
		}
		LOG.info("-----------");
		for (Activity activity : activities) {
			if (activity.getResult() == null) {
				try {
					activity.run();
				} catch (Throwable e) {
					if (e.getMessage() != null 
							&& !e.getMessage().equalsIgnoreCase(EXCEPTION_TEST_TEXT)) {
						e.printStackTrace();
					}
					LOG.severe("Continuing after an error in processing activity " + activity + ";\n  Exception=" + e);
				}
				optionalInternalWait();
				LOG.info("-----------");
			}
		}
	}

	private void optionalInternalWait() {
		if (getInternalDelay() > 0) {
			try {
				LOG.log(Level.INFO, "Waiting for " + getInternalDelay() + "[ms]");
				Thread.sleep(getInternalDelay());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void readPropertiesFile() {
		try {
			FileInputStream is = new FileInputStream(PROP_FILE);
			getProperties().load(is);
			String internalDelayString = getProperties().getProperty("InternalDelay");
			if (internalDelayString != null) {
				setInternalDelay(Long.valueOf(internalDelayString));
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract ArrayList<Activity> getActivities();
}
