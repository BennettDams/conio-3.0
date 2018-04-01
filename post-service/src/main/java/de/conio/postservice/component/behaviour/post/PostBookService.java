package de.conio.conio.connector.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.conio.connector.jpa.behaviour.dao.post.PostBookRepository;
import de.conio.conio.connector.jpa.behaviour.service.CrudService;
import de.conio.conio.connector.jpa.structure.post.BookEntity;

@Service
public class PostBookService extends CrudService<BookEntity> {
	 
	@Autowired
	PostBookRepository<BookEntity> bookRepository;

	@Override
	protected PostBookRepository<BookEntity> getRepository() {
		return bookRepository;
	}

}
