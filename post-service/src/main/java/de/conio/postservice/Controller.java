package de.conio.postservice;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/")
	public String demo(@RequestHeader("X-source") String source){
		return "First service with " + source;
	}
	
	@RequestMapping("/x")
	  public String available() {
	    return "Spring in Action";
	  }
}