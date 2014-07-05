package com.marzeta.wfengine.model.common;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class EntityCommon implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name = "";

	private String id = "";

	public EntityCommon() {
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
}
