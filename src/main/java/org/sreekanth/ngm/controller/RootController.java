package org.sreekanth.ngm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sreekanth.ngm.dao.User;
import org.sreekanth.ngm.service.ItemService;

@Controller
public class RootController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@RequestMapping(value="/inventory", method=RequestMethod.GET)
	public String getInventory(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("categories", itemService.listCategories());
		model.addAttribute("items", itemService.listItems());
		return "inventory";
	}

	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String viewCart(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user", user);
		return "cart";
	}

	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String checkout(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user", user);
		return "checkout";
	}

}
