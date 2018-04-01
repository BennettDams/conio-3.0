package de.conio.postservice.component.structure;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

@Entity
@Indexed
@Table(name = "post_movie")
@PrimaryKeyJoinColumn(name="post_id")
public class MovieEntity extends PostEntity {

	public MovieEntity() {
		super();
	}
}
