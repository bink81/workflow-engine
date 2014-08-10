package com.marzeta.wfengine.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.marzeta.wfengine.model.common.EntityCommon;

@Entity
@Table
public class ContextDef extends EntityCommon {
	private static final long serialVersionUID = 1L;

	@NotNull
	public static final ContextDef DUMMY = new ContextDef();

	@OneToMany(mappedBy = "contextDef")
	private final List<ContextObjectDef> contextObjectDefs = new ArrayList<>();

	public ContextDef() {
	}

	@Override
	public String toString() {
		return "ContextDef [" + super.toString() + ", contextObjectDefs.size=" + getContextObjectDefs().size() + "]";
	}

	public List<ContextObjectDef> getContextObjectDefs() {
		return contextObjectDefs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.contextObjectDefs.hashCode();
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
		ContextDef other = (ContextDef) obj;
		if ((this.contextObjectDefs.size() > 0 || other.contextObjectDefs.size() > 0)
				&& !this.contextObjectDefs.equals(other.contextObjectDefs))
			return false;
		return true;
	}
}
