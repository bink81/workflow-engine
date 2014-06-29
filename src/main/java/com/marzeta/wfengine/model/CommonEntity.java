package com.marzeta.wfengine.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class CommonEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name = "";
	@Id
	@GeneratedValue
	private String id = "";

	public CommonEntity() {
		setId(getCurrentTime());
	}

	// ---------------------------------------------------------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ",name=" + getName();
	}

	private String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd-hh.mm.ss.SSS");
		String strDate = sdf.format(date);
		return strDate;
	}

	@Override
	public final boolean equals(Object other) {
		if (this == other) return true;
    if (other == null) return false;
		if (other instanceof CommonEntity) {
			CommonEntity that = (CommonEntity) other;
			return (this.getId() == that.getId() && this.getClass().equals(that.getClass()));
		}
		return false;
	}

	@Override
	public final int hashCode() {
		return getId().hashCode();
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
