package com.marzeta.wfengine.model;

import com.marzeta.wfengine.commons.IResult;

public abstract class TransitionCommonEntity extends CommonEntity {
	private static final long serialVersionUID = 1L;
	private long delay = 0;
	private IResult result = null;

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public IResult getResult() {
		return result;
	}

	public void setResult(IResult result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return super.toString() + "-" + getResult();
	}
}
