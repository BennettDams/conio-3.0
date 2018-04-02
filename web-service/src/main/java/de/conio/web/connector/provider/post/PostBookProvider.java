package de.conio.web.connector.provider.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.core.structure.Book;
import de.conio.core.structure.PostComment;
import de.conio.core.structure.Tutorial;
import de.conio.web.connector.RESTController;
import de.conio.web.connector.consumer.post.PostBookConsumer;
import de.conio.web.connector.consumer.post.PostCategoryConsumer;
import de.conio.web.helper.PostHelper;

/**
 * 
 * @author Jonas
 * 
 *         TODO: http://www.baeldung.com/spring-new-requestmapping-shortcuts
 */
@Controller
@RequestMapping("posts/book")
public class PostBookProvider extends RESTController<Book> {
	
	@Autowired
	private PostBookConsumer bookConsumer;

	@Autowired
	private PostCategoryConsumer categoryConsumer;
	
	@Override
	public String index(Model model) {

		model.addAttribute("posts", bookConsumer.readAll());
		model.addAttribute("categories", categoryConsumer.readAll());

		return "posts/book/index";
	}

	@Override
	public String newForm(Model model) {

		model.addAttribute("post", new Tutorial());
		model.addAttribute("categories", categoryConsumer.readAll());

		return "posts/book/new";
	}

	@Override
	public String show(@PathVariable("id") Long id, Model model) {
		Book post = bookConsumer.read(id);

		if (post != null) {
			List<PostComment> comments = PostHelper.toThreadedComments(post.getTopLevelComments());

			model.addAttribute("comments", comments);
			model.addAttribute("post", post);

			return "posts/book/show";
		}

		return "redirect:/posts/book";
	}

	@Override
	public String create(Book entity, String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Long id, Book entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String destroy(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editForm(String type, Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public String create(@ModelAttribute Book post, @ModelAttribute(name = "categoryId") String categoryId) {

		post.setCategory(categoryConsumer.read(Long.parseLong(categoryId)));

		this.bookService.save(post);

		return "redirect:/posts/book";
	}

	@Override
	public String update(@PathVariable("id") Long id, @ModelAttribute BookEntity post) {

		return "redirect:/posts/book";
	}

	@Override
	public String destroy(@PathVariable("id") Long id) {

		this.bookService.delete(id);
		return "redirect:/posts/book";
	}

	@Override
	public String editForm(@ModelAttribute(name = "type") String type, @PathVariable("id") Long id, Model model) {
		if (type.length() == 0 || type == null) {
			return "redirect:/posts/book";
		}

		model.addAttribute("post", bookService.read(id));

		return "posts/book/edit";
	}

	// =====================
	// Comments
	// =====================

	// NEW COMMENT
	@GetMapping("/{id}/comments/new")
	public String commentsNew(@PathVariable("id") Long id, @RequestParam("parentId") Optional<String> parentId,
			Model model) {
		PostCommentEntity postComment = new PostCommentEntity();

		if (!parentId.isPresent()) {
			model.addAttribute("parentId", 0);
		} else {
			model.addAttribute("parentId", parentId.get());
		}

		model.addAttribute("postComment", postComment);
		model.addAttribute("postId", id);

		return "post_comments/new";
	}

	// EDIT COMMENT
	@GetMapping("/{id}/comments/{commentId}/edit")
	public String editForm(@PathVariable("id") Long id, @PathVariable("commentId") Long commentId) {
		return "posts_comments/edit";
	}

	// CREATE:
	@PostMapping("{id}/comments")
	public String addComment(@PathVariable("id") String id, @ModelAttribute PostCommentEntity postComment) {
		BookEntity book = bookService.read(Long.parseLong(id));

		postComment.setUser(SecurityUtils.getCurrentUser(userService));
		postComment.setPost(book);

		book.addComment(postComment);

		bookService.save(book);

		return "redirect:/posts/" + id;
	}*/
}