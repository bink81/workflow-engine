package com.marzeta.wfengine.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
public class ContextDef extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	public static final ContextDef DUMMY = new ContextDef();

	private HashMap<String, Object> contextObjectDefs = new HashMap<String, Object>();

	public HashMap<String, Object> getContextObjectDefs() {
		return contextObjectDefs;
	}

	public void setContextObjectDefs(HashMap<String, Object> contextObjectDefs) {
		this.contextObjectDefs = contextObjectDefs;
	}

	@Override
	public String toString() {
		return "ContextDef [" + super.toString() + ", contextObjectDefs=" + contextObjectDefs + "]";
	}
}
