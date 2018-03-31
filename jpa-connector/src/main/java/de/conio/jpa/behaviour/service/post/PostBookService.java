package de.conio.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.jpa.behaviour.dao.post.PostBookRepository;
import de.conio.jpa.behaviour.service.CrudService;
import de.conio.jpa.structure.post.BookEntity;

@Service
public class PostBookService extends CrudService<BookEntity> {
	 
	@Autowired
	PostBookRepository<BookEntity> bookRepository;

	@Override
	protected PostBookRepository<BookEntity> getRepository() {
		return bookRepository;
	}

}
