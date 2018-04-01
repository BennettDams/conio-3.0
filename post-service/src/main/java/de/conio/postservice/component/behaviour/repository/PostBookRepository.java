package de.conio.postservice.component.behaviour.repository;

import javax.transaction.Transactional;

import de.conio.postservice.component.structure.BookEntity;

@Transactional
public interface PostBookRepository<T> extends PostBaseRepository<BookEntity> {

	
}
