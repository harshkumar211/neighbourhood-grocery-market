package org.sreekanth.sbsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sreekanth.sbsample.model.Person;
import org.sreekanth.sbsample.service.PersonService;

@Controller
public class RootController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "index";
	}
	
	@RequestMapping(value="/person/new", method=RequestMethod.GET)
	public String newPerson(Model model) {
		model.addAttribute("person", new Person());
		return "newperson";
	}
	
	@RequestMapping(value="/person/edit/{id}", method=RequestMethod.GET)
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", personService.getPersonById(id));
		return "editperson";
	}
	
	@RequestMapping(value="/person/add", method=RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p) {
		personService.addPerson(p);
		return "redirect:/";
	}
	
	@RequestMapping(value="/person/update", method=RequestMethod.POST)
	public String updatePerson(@ModelAttribute("person") Person p) {
		personService.updatePerson(p);
		return "redirect:/";
	}
	
	@RequestMapping(value="/person/delete/{id}")
	public String deletePerson(@PathVariable("id") int id) {
		personService.removePerson(id);
		return "redirect:/";
	}

}
