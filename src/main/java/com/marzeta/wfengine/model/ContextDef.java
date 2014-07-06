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
}
