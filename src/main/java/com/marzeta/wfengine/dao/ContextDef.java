package com.marzeta.wfengine.dao;

import com.marzeta.wfengine.model.ContextDefEntity;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
public class ContextDef extends ContextDefEntity {
	private static final long serialVersionUID = 1L;

	public ContextDef() {
	}

	@Version
	protected Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
