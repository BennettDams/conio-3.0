package de.conio.jpa.behaviour.seed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import de.conio.core.structure.Post;
import de.conio.core.structure.PostAttachment;
import de.conio.core.structure.PostCategory;
import de.conio.core.structure.Role;
import de.conio.jpa.behaviour.service.RoleController;
import de.conio.jpa.behaviour.service.UserController;
import de.conio.jpa.behaviour.service.post.PostBookController;
import de.conio.jpa.behaviour.service.post.PostCategoryController;
import de.conio.jpa.behaviour.service.post.PostTutorialController;
import de.conio.jpa.structure.post.BookEntity;
import de.conio.jpa.structure.post.PostCategoryEntity;
import de.conio.jpa.structure.post.TutorialEntity;
import de.conio.jpa.structure.security.RoleEntity;
import de.conio.jpa.structure.user.UserEntity;

@Component
public class DatabaseSeeder {

	//private Logger logger = Logger.getLogger(DatabaseSeeder.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PostTutorialController tutorialService;

	@Autowired
	private PostBookController bookService;

	@Autowired
	private UserController userService;

	@Autowired
	private RoleController roleService;
	
	@Autowired
	private PostCategoryController postCategoryService;

	@Autowired
	public DatabaseSeeder(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		//seedPostAttachmentTable();
		seedPostCategoryTable();
		seedPostTable();
		seedRoleTable();
		seedUserTable();
	}

	private void seedPostTable() {
		String sql = "SELECT * FROM post LIMIT 1";
		List<Post> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
		if (rs == null || rs.size() <= 0) {
			
			TutorialEntity tutorial1 = new TutorialEntity();
			tutorial1.setBody("{\"ops\":[{\"insert\":\"Code sample\\n<div>\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"Ich bin toll\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"</div>\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"\\n\"},{\"attributes\":{\"bold\":true},\"insert\":\"Lorem ipsum\"},{\"insert\":\"\\nLorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\\n\"}]}");
			tutorial1.setTitle("I dont know what I am talking about");
			tutorial1.setImageUrl("https://images.unsplash.com/uploads/1413142095961484763cf/d141726c?auto=format&fit=crop&w=1350&q=80");
			
			TutorialEntity tutorial2 = new TutorialEntity();
			tutorial2.setBody("{\"ops\":[{\"insert\":\"Code sample\\n<div>\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"Ich bin toll\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"</div>\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"\\n\"},{\"attributes\":{\"bold\":true},\"insert\":\"Lorem ipsum\"},{\"insert\":\"\\nLorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\\n\"}]}");
			tutorial2.setTitle("Butterflies and blue wales");
			tutorial2.setImageUrl("https://images.unsplash.com/uploads/1413142095961484763cf/d141726c?auto=format&fit=crop&w=1350&q=80");
			
			tutorialService.save(tutorial1, "1");
			tutorialService.save(tutorial2, "1");

			BookEntity book1 = new BookEntity();
			book1.setBody("{\"ops\":[{\"insert\":\"Code sample\\n<div>\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"Ich bin toll\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"</div>\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"\\n\"},{\"attributes\":{\"bold\":true},\"insert\":\"Lorem ipsum\"},{\"insert\":\"\\nLorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\\n\"}]}");
			book1.setTitle("Eragon");
			book1.setImageUrl("https://images.unsplash.com/uploads/1413142095961484763cf/d141726c?auto=format&fit=crop&w=1350&q=80");
	
			BookEntity book2 = new BookEntity();
			book2.setBody("{\"ops\":[{\"insert\":\"Code sample\\n<div>\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"Ich bin toll\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"</div>\"},{\"attributes\":{\"code-block\":true},\"insert\":\"\\n\"},{\"insert\":\"\\n\"},{\"attributes\":{\"bold\":true},\"insert\":\"Lorem ipsum\"},{\"insert\":\"\\nLorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\\n\"}]}");
			book2.setTitle("Lord of the rings");
			book2.setImageUrl("https://images.unsplash.com/uploads/1413142095961484763cf/d141726c?auto=format&fit=crop&w=1350&q=80");

			bookService.save(book1, "1");
			bookService.save(book2, "1");

			//logger.info("post table seeded");
		} else {
			//logger.trace("Post seeding Not Required");
		}
	}
	
	private void seedPostCategoryTable() {
		String sql = "SELECT * FROM post_category LIMIT 1";
		List<PostCategory> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
		if (rs == null || rs.size() <= 0) {
			PostCategoryEntity pc = new PostCategoryEntity();
			pc.setName("default");

			postCategoryService.save(pc, "1");

			//logger.info("Post Category table seeded");
		} else {
			//logger.trace("Post Category table seeding Not Required");
		}
	}


	/*private void seedPostAttachmentTable() {
		String sql = "SELECT * FROM post_attachment LIMIT 1";
		List<PostAttachment> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
		if (rs == null || rs.size() <= 0) {
			PostAttachment c1 = new PostAttachment();
			c1.setName("Picture");
			PostAttachment c2 = new PostAttachment();
			c2.setName("YouTube");

			logger.info("PostAttachment table seeded");
		} else {
			logger.trace("PostAttachment seeding Not Required");
		}
	}*/

	private void seedRoleTable() {
		String sql = "SELECT * FROM role LIMIT 1";
		List<Role> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
		if (rs == null || rs.size() <= 0) {
			RoleEntity r1 = new RoleEntity("ADMIN", "admin", "The admin has access to all features of the website");

			roleService.save(r1, "1");

			//logger.info("Role table seeded");
		} else {
			//logger.trace("Role table seeding Not Required");
		}
	}

	private void seedUserTable() {
		String sql = "SELECT * FROM user LIMIT 1";
		List<PostAttachment> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
		if (rs == null || rs.size() <= 0) {
			UserEntity u1 = new UserEntity("Bennett", "mail@bennett", "admin");
			UserEntity u2 = new UserEntity("Jonas", "mail@jonas", "admin");

			RoleEntity r1 = roleService.findOneByName("ADMIN");
			u1.addRole(r1);
			u2.addRole(r1);

			userService.save(u1, "1");
			userService.save(u2, "1");

			//logger.info("User table seeded");
		} else {
			//logger.trace("User table seeding Not Required");
		}
	}

}