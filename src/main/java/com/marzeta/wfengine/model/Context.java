package com.marzeta.wfengine.model;

import java.util.HashMap;

import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.EntityCommon;

public class Context extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	private final ContextDef contextDef;

	private final HashMap<String, Object> contextObjects = new HashMap<String, Object>();

	public Context(@NotNull ContextDef contextDef) {
		this.contextDef = contextDef;
		setName(contextDef.getName());
		HashMap<String, Object> contextObjectDefs = contextDef.getContextObjectDefs();
		for (String key : contextObjectDefs.keySet()) {
			Object value = contextObjectDefs.get(key);
			getContextObjects().put(key, value);
		}
	}

	public ContextDef getContextDef() {
		return contextDef;
	}

	public HashMap<String, Object> getContextObjects() {
		return contextObjects;
	}

	@Override
	public String toString() {
		return "Context [" + super.toString() + ", contextDef=" + contextDef + ", contextObjects=" + contextObjects + "]";
	}
}
