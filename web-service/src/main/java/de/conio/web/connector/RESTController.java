package de.conio.web.connector;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class RESTController<T> {

	// INDEX:
	// GET www.yelpCamp.com/campgrounds
	@GetMapping("")
	public abstract String index(Model model);

	// NEW:
	// GET www.yelpCamp.com/campgrounds/new
	// -> click on submit button and go to CREATE Route
	@GetMapping("/new")
	public abstract String newForm(Model model);

	// SHOW:
	// GET www.yelpCamp.com/campgrounds/:id
	@GetMapping("/{id}")
	public abstract String show(@PathVariable("id") Long id, Model model);

	// CREATE:
	// POST www.yelpCamp.com/campgrounds
	@PostMapping("")
	public abstract String create(@ModelAttribute T entity, @ModelAttribute(name = "categoryId") String categoryId);

	// UPDATE:
	// PUT www.yelpCamp.com/campgrounds/:id
	@PutMapping("/{id}")
	public abstract String update(@PathVariable("id") Long id, @ModelAttribute T entity);

	// DESTROY:
	// DELETE www.yelpCamp.com/campgrounds/:id
	@PostMapping("/{id}")
	public abstract String destroy(@PathVariable("id") Long id);

	// EDIT:
	// GET www.yelpCamp.com/campgrounds/:id/edit
	// -> click on submit button and go to UPDATE Route
	@GetMapping("/{id}/edit")
	public abstract String editForm(@ModelAttribute(name = "type") String type, @PathVariable("id") Long id, Model model);
}
