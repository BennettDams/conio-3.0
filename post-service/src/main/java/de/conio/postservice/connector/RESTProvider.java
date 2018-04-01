package de.conio.postservice.connector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.core.structure.Base;

public abstract class RESTProvider<T extends Base> {

	// save and update
	@GetMapping("")
	public abstract void save(@ModelAttribute T object, @ModelAttribute(name = "categoryId") String categoryId);

	@PutMapping("/{id}")
	public abstract void update(@PathVariable("id") Long id, @ModelAttribute T object);
	
	@PostMapping("/{id}")
	public abstract void delete(@PathVariable("id") Long id);

	@GetMapping("/{id}")
	public abstract @ResponseBody T read(@PathVariable("id") Long id);

	@GetMapping("/all")
	public abstract @ResponseBody Iterable<T> readAll();

}
