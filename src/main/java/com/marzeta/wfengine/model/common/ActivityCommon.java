package com.marzeta.wfengine.model.common;

public abstract class ActivityCommon extends EntityCommon {
	private static final long serialVersionUID = 1L;

	private boolean urgent = false;

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	@Override
	public String toString() {
		return super.toString() + ", urgent=" + isUrgent();
	}
}
