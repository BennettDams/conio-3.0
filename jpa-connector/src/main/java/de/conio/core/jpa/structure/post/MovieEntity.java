package de.conio.core.jpa.structure.post;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Table(name = "post_movie")
@PrimaryKeyJoinColumn(name="post_id")
public class MovieEntity extends PostEntity {

	public MovieEntity() {
		super();
	}
}
