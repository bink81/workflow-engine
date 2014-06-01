package com.marzeta.wfengine.commons;

import java.io.Serializable;

public interface IActivityDef extends Serializable {
	public IResult execute() throws Throwable;
}
