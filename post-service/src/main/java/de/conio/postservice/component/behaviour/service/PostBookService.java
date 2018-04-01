package de.conio.postservice.component.behaviour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.core.structure.Book;
import de.conio.postservice.component.behaviour.mapper.BookMapper;
import de.conio.postservice.component.behaviour.repository.PostBookRepository;
import de.conio.postservice.component.structure.BookEntity;

@Service
public class PostBookService extends CrudService<BookEntity, Book> {

	@Autowired
	PostBookRepository<BookEntity> bookRepository;

	@Override
	protected PostBookRepository<BookEntity> getRepository() {
		return bookRepository;
	}

	@Override
	public void save(Book object) {
		getRepository().save(BookMapper.convert2BookEntity(object));
	}

	@Override
	public Book read(long id) {
		return BookMapper.convert2Book(getRepository().findById(id).get());
	}

	@Override
	public Iterable<Book> readAll() {
		Iterable<BookEntity> entities = getRepository().findAll();
		List<Book> objects = new ArrayList();
		for (BookEntity t : entities) {
			objects.add(BookMapper.convert2Book(t));
		}

		return objects;
	}

}
