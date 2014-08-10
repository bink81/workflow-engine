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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.contextDef.hashCode();
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
		ContextObjectDef other = (ContextObjectDef) obj;
		if (!this.contextDef.equals(other.contextDef))
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
