package com.marzeta.wfengine.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
@Table
public class ContextObjectDef extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	private ContextDef contextDef = ContextDef.DUMMY;

	private String value;

	@NotNull
	private String key = "DUMMY";

	protected ContextObjectDef() {
	}

	public ContextObjectDef(@NotNull ContextDef contextDef, @NotNull String key, String value) {
		this.contextDef = contextDef;
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "ContextObjectDef [" + super.toString() + ", contextDef=" + contextDef + "]";
	}

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}
}
