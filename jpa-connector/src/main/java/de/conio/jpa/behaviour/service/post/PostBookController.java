package de.conio.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.jpa.behaviour.dao.post.PostBookRepository;
import de.conio.jpa.behaviour.service.CrudController;
import de.conio.jpa.structure.post.BookEntity;

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
	public void save(@ModelAttribute BookEntity entity, @ModelAttribute(name = "categoryId") String categoryId) {
		entity.setCategory(postCategoryController.read(Long.parseLong(categoryId)));
		getRepository().save(entity);
	}

	@Override
	public void update(@PathVariable("id") Long id, @ModelAttribute BookEntity entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(@PathVariable("id") Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public @ResponseBody BookEntity read(@PathVariable("id") Long id) {
		return getRepository().findById(id).get();
	}

	@Override
	public @ResponseBody Iterable<BookEntity> readAll() {
		return getRepository().findAll();
	}

}
