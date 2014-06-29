package com.marzeta.wfengine.model;

import java.util.HashMap;

import com.marzeta.wfengine.dao.ContextDef;

public class ContextEntity extends CommonEntity {
	private static final long serialVersionUID = 1L;
	private ContextDef contextDef = null;
	private HashMap<String, Object> contextObjects = new HashMap<String, Object>();
	
	public ContextDef getContextDef() {
		return contextDef;
	}

	public void setContextDef(ContextDef contextDef) {
		this.contextDef = contextDef;
	}

	public HashMap<String, Object> getContextObjects() {
		return contextObjects;
	}

	public void setContextObjects(HashMap<String, Object> contextObjects) {
		this.contextObjects = contextObjects;
	}
}
