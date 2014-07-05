package com.marzeta.wfengine.model.common;

public abstract class TransitionCommon extends EntityCommon {
	private static final long serialVersionUID = 1L;

	private long delay = 0;

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	@Override
	public String toString() {
		return super.toString() + ", delay=" + delay;
	}
}
