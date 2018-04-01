package de.conio.jpa.behaviour.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.jpa.structure.BaseEntity;

public abstract class CrudController<T extends BaseEntity> {

	protected abstract CrudRepository<T, Long> getRepository();

	// save and update
	@GetMapping("")
	public abstract void save(@ModelAttribute T entity, @ModelAttribute(name = "categoryId") String categoryId);

	@PutMapping("/{id}")
	public abstract void update(@PathVariable("id") Long id, @ModelAttribute T entity);
	
	@PostMapping("/{id}")
	public abstract void delete(@PathVariable("id") Long id);

	@GetMapping("/{id}")
	public abstract @ResponseBody T read(@PathVariable("id") Long id);

	@GetMapping("/all")
	public abstract @ResponseBody Iterable<T> readAll();

}
