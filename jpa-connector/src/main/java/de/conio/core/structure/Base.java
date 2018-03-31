package de.conio.core.structure;

import java.io.Serializable;
import java.util.Date;

public abstract class Base implements Serializable {

	private Long id;

	private Date createTime;

	private Date lastModified;

	public Long getId() {
		return id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}
