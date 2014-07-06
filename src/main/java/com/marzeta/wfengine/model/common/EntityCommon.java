package com.marzeta.wfengine.model.common;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class EntityCommon implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 30)
	private String name = "";

	@Id
	@GeneratedValue
	private String id = "";

	public EntityCommon() {
		setId(getCurrentTime());
	}

	// ---------------------------------------------------------------
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd-hh.mm.ss.SSS");
		String strDate = sdf.format(date);
		return strDate;
	}

	@Override
	public final boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (other instanceof EntityCommon) {
			EntityCommon that = (EntityCommon) other;
			return (this.getId() == that.getId() && this.getClass().equals(that.getClass()));
		}
		return false;
	}

	@Override
	public final int hashCode() {
		return getId().hashCode();
	}

	@Override
	public String toString() {
		return ", name=" + name + ", id=" + id;
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
