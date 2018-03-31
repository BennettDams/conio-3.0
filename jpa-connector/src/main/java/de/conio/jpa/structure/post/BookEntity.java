package de.conio.jpa.structure.post;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Table(name = "post_book")
@PrimaryKeyJoinColumn(name="post_id")
public class BookEntity extends PostEntity {

	public BookEntity() {
		super();
	}
}
