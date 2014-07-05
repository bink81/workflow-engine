package com.marzeta.wfengine.model;

import java.util.HashMap;

import com.marzeta.wfengine.model.common.EntityCommon;

public class ContextDef extends EntityCommon {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> contextObjectDefs = new HashMap<String, Object>();

	public HashMap<String, Object> getContextObjectDefs() {
		return contextObjectDefs;
	}

	public void setContextObjectDefs(HashMap<String, Object> contextObjectDefs) {
		this.contextObjectDefs = contextObjectDefs;
	}

	public ContextDef() {
	}
}
