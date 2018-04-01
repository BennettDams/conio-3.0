package de.conio.postservice.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.core.structure.Book;
import de.conio.postservice.component.behaviour.service.PostBookService;
import de.conio.postservice.component.behaviour.service.PostCategoryService;

@Controller
@RequestMapping("post-book")
public class PostBookProvider extends RESTProvider<Book> {

	@Autowired
	private PostBookService bookService;
	
	@Autowired
	private PostCategoryService postCategoryService;
	
	@Override
	public void save(@ModelAttribute Book object, @ModelAttribute(name = "categoryId") String categoryId) {
		object.setCategory(postCategoryService.read(Long.parseLong(categoryId)));

		this.bookService.save(object);
	}

	@Override
	public void update(@PathVariable Long id, @ModelAttribute Book object) {
		bookService.save(object);
	}

	@Override
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}

	@Override
	public @ResponseBody Book read(@PathVariable Long id) {
		return bookService.read(id);
	}

	@Override
	public @ResponseBody Iterable<Book> readAll() {
		return bookService.readAll();
	}

}
