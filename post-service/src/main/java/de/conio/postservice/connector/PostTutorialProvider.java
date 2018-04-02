package de.conio.postservice.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.core.structure.Tutorial;
import de.conio.postservice.component.behaviour.repository.PostTutorialRepository;
import de.conio.postservice.component.behaviour.service.PostCategoryService;
import de.conio.postservice.component.behaviour.service.PostTutorialService;
import de.conio.postservice.component.structure.TutorialEntity;

@Controller
@RequestMapping("tutorial")
public class PostTutorialProvider extends RESTProvider<Tutorial> {
	 
	@Autowired
	private PostTutorialService tutorialService;
	
	@Autowired
	private PostCategoryService postCategoryService;

	@Override
	public void save(@ModelAttribute Tutorial object, @ModelAttribute(name = "categoryId") String categoryId) {
		object.setCategory(postCategoryService.read(Long.parseLong(categoryId)));

		this.tutorialService.save(object);
		
	}

	@Override
	public void update(@PathVariable Long id, @ModelAttribute Tutorial object) {
		tutorialService.save(object);
		
	}

	@Override
	public void delete(@PathVariable Long id) {
		tutorialService.delete(id);
		
	}

	@Override
	public @ResponseBody Tutorial read(@PathVariable Long id) {
		return tutorialService.read(id);
	}

	@Override
	public @ResponseBody Iterable<Tutorial> readAll() {
		return tutorialService.readAll();
	}
	


}
