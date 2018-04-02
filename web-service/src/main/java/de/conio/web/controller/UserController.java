package de.conio.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.conio.connector.jpa.behaviour.service.UserService;
import de.conio.conio.connector.jpa.structure.user.UserEntity;

/**
 * 
 * @author Bennett
 * 
 *         TODO: http://www.baeldung.com/spring-new-requestmapping-shortcuts
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user/index";
	}

	// NEW:
	@GetMapping("/new")
	public String newForm(Model model) {

		UserEntity user = new UserEntity();
		model.addAttribute("user", user);

		return "user/new";
	}

	// SHOW:
	@GetMapping("/{username}")
	public String show(@PathVariable("username") String username, Model model) {
		UserEntity user = userService.findOneByUsername(username);
		if (user != null) {
			model.addAttribute("user", user);
			return "user/show";
		}
		
		return "redirect:/error/404";
	}

	// old findBy ID
	// SHOW:
	// GET www.yelpCamp.com/campgrounds/:id
	// @GetMapping("/{id}")
	// public String show(@PathVariable("id") Long id, Model model) {
	// User user = userService.findById(id);
	//
	// if (user != null) {
	// model.addAttribute("user", user);
	// return "user/show";
	// }
	//
	// return "redirect:/user/";
	// }

	// CREATE:
	@PostMapping("/")
	public String addUser(@ModelAttribute UserEntity user) {
		this.userService.save(user);

		return "redirect:/user/show";
	}

	// UPDATE:
	@PutMapping("/{username}")
	public String update(@PathVariable("username") String username, @ModelAttribute UserEntity user) {

		this.userService.save(user);
		return "redirect:/user/show";
	}

	// DESTROY:
	@PostMapping("/{username}")
	public String destroy(@PathVariable("username") String username) {
		Long id = userService.findOneByUsername(username).getId();
		this.userService.delete(id);
		return "redirect:/user/";
	}

	// EDIT:
	@GetMapping("/{username}/edit")
	public String editForm(@PathVariable("username") String username) {
		return "user/edit";
	}

}