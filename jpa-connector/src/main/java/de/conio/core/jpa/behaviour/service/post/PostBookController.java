package de.conio.core.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.core.jpa.behaviour.dao.post.PostBookRepository;
import de.conio.core.jpa.behaviour.service.CrudController;
import de.conio.core.jpa.structure.post.BookEntity;

@Controller
@RequestMapping("post-book")
public class PostBookController extends CrudController<BookEntity> {
	 
	@Autowired
	PostBookRepository<BookEntity> bookRepository;
	
	@Autowired
	PostCategoryController postCategoryController;

	@Override
	protected PostBookRepository<BookEntity> getRepository() {
		return bookRepository;
	}

	@Override
	public void save(BookEntity entity, String categoryId) {
		entity.setCategory(postCategoryController.read(Long.parseLong(categoryId)));
		getRepository().save(entity);
	}

	@Override
	public void update(Long id, BookEntity entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public BookEntity read(Long id) {
		return getRepository().findById(id).get();
	}

	@Override
	public Iterable<BookEntity> readAll() {
		return getRepository().findAll();
	}

}
