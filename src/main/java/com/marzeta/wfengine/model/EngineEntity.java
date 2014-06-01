package com.marzeta.wfengine.model;

import java.util.Properties;

import com.marzeta.wfengine.commons.Storage;

public class EngineEntity extends CommonEntity {
	private static final long serialVersionUID = 1L;
	private String name = "DefaultEngineName";
	private Properties properties = new Properties();
	private long internalDelay = 0;
	private Storage storage = new Storage();

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public long getInternalDelay() {
		return internalDelay;
	}

	public void setInternalDelay(long internalDelay) {
		this.internalDelay = internalDelay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
