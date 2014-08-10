package com.marzeta.wfengine.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
@Table
public class ContextObject extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.context.hashCode();
		result = prime * result + this.key.hashCode();
		result = prime * result + this.value.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContextObject other = (ContextObject) obj;
		if (!this.context.equals(other.context))
			return false;
		if (!this.key.equals(other.key))
			return false;
		if (this.value == null) {
			if (other.value != null)
				return false;
		} else if (!this.value.equals(other.value))
			return false;
		return true;
	}
}
