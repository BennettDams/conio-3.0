package de.conio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

	@GetMapping("/login")
	public String login() {
		return "authentication/login";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "authentication/login";
	}
}
