package com.cooksys;

import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

	
@Validated
@RequestMapping("person")
@RestController
public class PersonController {
	
	private PersonService personService;
	
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	@RequestMapping(method = RequestMethod.HEAD, value = "{id}")
	public void has(@PathVariable Long id, HttpServletResponse response) {
		if(!personService.has(id))
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
	
	@GetMapping("{id}")
	public PersonDto get(@PathVariable Long id, HttpServletResponse response) {
		PersonDto dto = personService.get(id);
		if (dto == null)
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return dto;
	}
	
	@PostMapping
	public Long add(@RequestBody @Validated Person person, HttpServletResponse response) {
		Long result = personService.add(person);
		if(result > 0)
			response.setStatus(HttpServletResponse.SC_CREATED);
		return result;
	}
	
	@PutMapping("{id}")
	public void put(@PathVariable Long id, @RequestBody @Validated Person person, HttpServletResponse response) {
		personService.put(id, person);
	}
	
	@PatchMapping("{id}")
	public void post(@PathVariable Long id, @RequestBody @Validated Person person, HttpServletResponse response) {
		personService.post(id, person);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}
}