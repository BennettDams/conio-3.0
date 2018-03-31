package de.conio.core.jpa.structure.post;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;


@Entity
@Indexed
@Table(name = "post_series")
@PrimaryKeyJoinColumn(name="post_id")
public class SeriesEntity extends PostEntity {

	public SeriesEntity() {
		super();
	}
}
