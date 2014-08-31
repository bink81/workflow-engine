package com.marzeta.wfengine.model.common;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class EntityCommon implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 30)
	private String name = "";

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	protected EntityCommon() {
	}

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result + (this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityCommon other = (EntityCommon) obj;
		if (this.id != other.id)
			return false;
		if (!this.name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ", name=" + name + ", id=" + id + ", ";
	}
}
