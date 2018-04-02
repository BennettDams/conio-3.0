package de.conio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping("/")
	public String index() {
		return "home";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	// STYLEGUIDE
	@GetMapping("/styleguide")
	public String styleguide() {
		return "styleguide";
	}

	// ERROR
	@GetMapping("/*")
	public String error404() {
		return "error/404";
	}
}
