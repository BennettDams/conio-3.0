package de.conio.web.controller.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.conio.conio.connector.jpa.behaviour.service.UserService;
import de.conio.conio.connector.jpa.behaviour.service.post.PostBookService;
import de.conio.conio.connector.jpa.behaviour.service.post.PostCategoryService;
import de.conio.conio.connector.jpa.structure.post.BookEntity;
import de.conio.conio.connector.jpa.structure.post.PostCommentEntity;
import de.conio.conio.connector.jpa.structure.post.TutorialEntity;
import de.conio.conio.mvc.controller.RESTController;
import de.conio.conio.mvc.helper.PostHelper;
import de.conio.conio.mvc.security.SecurityUtils;

/**
 * 
 * @author Jonas
 * 
 *         TODO: http://www.baeldung.com/spring-new-requestmapping-shortcuts
 */
@Controller
@RequestMapping("posts/book")
public class PostBookController extends RESTController<BookEntity> {

	@Autowired
	private PostBookService bookService;

	@Autowired
	private PostCategoryService postCategoryService;

	@Autowired
	private UserService userService;

	@Override
	public String index(Model model) {

		model.addAttribute("posts", bookService.readAll());
		model.addAttribute("categories", postCategoryService.readAll());

		return "posts/book/index";
	}

	@Override
	public String newForm(Model model) {

		model.addAttribute("post", new TutorialEntity());
		model.addAttribute("categories", postCategoryService.readAll());

		return "posts/book/new";
	}

	@Override
	public String show(@PathVariable("id") Long id, Model model) {
		BookEntity post = bookService.read(id);

		if (post != null) {
			List<PostCommentEntity> comments = PostHelper.toThreadedComments(post.getTopLevelComments());

			model.addAttribute("comments", comments);
			model.addAttribute("post", post);

			return "posts/book/show";
		}

		return "redirect:/posts/book";
	}

	@Override
	public String create(@ModelAttribute BookEntity post, @ModelAttribute(name = "categoryId") String categoryId) {

		post.setCategory(postCategoryService.read(Long.parseLong(categoryId)));

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
	}
}