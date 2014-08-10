package com.marzeta.wfengine.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
@Table
public class ContextObject extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	private Context context = Context.DUMMY;

	private String value;

	@NotNull
	private String key = "DUMMY";

	protected ContextObject() {
	}

	public ContextObject(@NotNull Context context, @NotNull String key, String value) {
		this.context = context;
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "ContextObjectDef [" + super.toString() + ", context=" + context + "]";
	}

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}
}
