package com.marzeta.wfengine.service;

import java.util.Properties;

import com.marzeta.wfengine.commons.Storage;

public class EngineEntity {

	private Properties properties = new Properties();

	private long internalDelay = 0;

	private Storage storage = new Storage();

	private final String name;

	public EngineEntity(String name) {
		this.name = name;
	}

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

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return "EngineEntity [" + super.toString() + ", properties=" + properties + ", internalDelay=" + internalDelay
				+ ", storage=" + storage + "]";
	}

	public String getName() {
		return name;
	}

}
