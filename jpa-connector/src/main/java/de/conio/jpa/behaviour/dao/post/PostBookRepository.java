package de.conio.jpa.behaviour.dao.post;

import javax.transaction.Transactional;

import de.conio.jpa.structure.post.BookEntity;

@Transactional
public interface PostBookRepository<T> extends PostBaseRepository<BookEntity> {

	
}
