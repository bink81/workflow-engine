package com.marzeta.wfengine.service;

import java.util.Properties;

import com.marzeta.wfengine.commons.Storage;
import com.marzeta.wfengine.model.common.EntityCommon;

public class EngineEntity extends EntityCommon {
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

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return "EngineEntity [" + super.toString() + ", name=" + name + ", properties=" + properties + ", internalDelay="
				+ internalDelay + ", storage=" + storage + "]";
	}

}
