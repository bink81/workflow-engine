package com.marzeta.wfengine.service;

import java.util.HashMap;

import com.marzeta.wfengine.dao.ContextDef;
import com.marzeta.wfengine.model.ContextEntity;

public class Context extends ContextEntity {
	private static final long serialVersionUID = 1L;

	public Context() {
	}

	public Context(ContextDef contextDef) {
		setContextDef(contextDef);
		setName(contextDef.getName());
		HashMap<String, Object> contextObjectDefs = contextDef.getContextObjectDefs();
		for (String key : contextObjectDefs.keySet()){
			Object value = contextObjectDefs.get(key);
			getContextObjects().put(key, value);
		}
	}
}
