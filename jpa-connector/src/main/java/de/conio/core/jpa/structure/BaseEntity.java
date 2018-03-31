package de.conio.core.jpa.structure;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 
 * @author Jonas
 *
 *         Based on
 *         https://chclaus.de/2016/02/25/jpa-mapped-superclass-meets-spring-data/
 * 
 *         Zitat: Aber eigentlich haben wir die o.g. ID vermutlich in allen
 *         unseren JPA-Entities - und nicht nur in unserer User-Entity. Daher
 *         lagern wir die Gemeinsamkeiten im nächsten Schritt in eine separate
 *         Klasse namens BaseEntity aus. Die Klasse BaseEntity bekommt die
 *         Annotation @MappedSuperclass. Damit wird klar, dass die Klasse selbst
 *         nicht persistiert wird, ihre Eigenschaft allerdings an die sie
 *         implementierenden Kinder abtritt.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Id
	private Long id;

	@Column(name = "create_time", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "last_modified")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
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
