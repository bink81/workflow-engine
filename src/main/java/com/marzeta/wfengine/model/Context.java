package com.marzeta.wfengine.model;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
public class Context extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull
	private ContextDef contextDef = ContextDef.DUMMY;

	private final HashMap<String, Object> contextObjects = new HashMap<String, Object>();

	protected Context() {
	}

	public Context(@NotNull ContextDef contextDef) {
		this.contextDef = contextDef;
		setName(contextDef.getName());
		List<ContextObjectDef> contextObjectDefs = contextDef.getContextObjectDefs();
		for (ContextObjectDef cod : contextObjectDefs) {
			Object value = cod.getValue();
			getContextObjects().put(cod.getKey(), value);
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
