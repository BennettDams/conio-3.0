package de.conio.core.jpa.behaviour.dao.post;

import javax.transaction.Transactional;

import de.conio.core.jpa.structure.post.BookEntity;

@Transactional
public interface PostBookRepository<T> extends PostBaseRepository<BookEntity> {

	
}
