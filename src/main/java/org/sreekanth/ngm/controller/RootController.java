package org.sreekanth.ngm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sreekanth.ngm.dao.User;
import org.sreekanth.ngm.model.Item;
import org.sreekanth.ngm.service.CartService;
import org.sreekanth.ngm.service.ItemService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class RootController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private CartService cartService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("user", new User());
//		createDummyObjectForTest();
		return "index";
	}

	@RequestMapping(value="/inventory", method=RequestMethod.GET)
	public String getInventory(@ModelAttribute("user") User user, HttpSession session, Model model) {
		session.setAttribute("username", user.getUsername());
		model.addAttribute("categories", itemService.listCategories());
		model.addAttribute("items", itemService.listItems());
		session.setAttribute("numOfItemsInCart", cartService.listCart().values().stream().mapToInt(Integer::valueOf).sum());
		return "inventory";
	}

	private void createDummyObjectForTest() {
		Runnable r = () -> {
			for(int i =0; i< 5000; i++){
				createObject();
				try {
					Thread.sleep(new Random().nextInt(2)*1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

		};
		for (int i=0; i<10; i++){
			new Thread(r).start();
		}
	}

	private void createObject(){
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<200; i++){
			builder.append(Content.text);
		}
		System.out.println("Created Stringbuilder object");

		// Get current size of heap in bytes
		long heapSize = Runtime.getRuntime().totalMemory();

		// Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
		long heapMaxSize = Runtime.getRuntime().maxMemory();

		// Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
		long heapFreeSize = Runtime.getRuntime().freeMemory();

		System.out.println("Current heap size: "+heapSize);
		System.out.println("Max heap size: "+heapMaxSize);
		System.out.println("Free heap size: "+heapFreeSize);
	}

	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String viewCart(@ModelAttribute("user") User user, HttpSession session, Model model) {
		model.addAttribute("user", user);
		Map<Item, Integer> cart = new HashMap<>();
		for (Map.Entry entry : cartService.listCart().entrySet()) {
			cart.put(itemService.getItemById((int)entry.getKey()), (int)entry.getValue());
		}
		model.addAttribute("cart", cart);
		session.setAttribute("numOfItemsInCart", cartService.listCart().values().stream().mapToInt(Integer::valueOf).sum());
		return "cart";
	}

	@RequestMapping(value="/cart/{id}", method=RequestMethod.POST)
	public void addOrUpdateItemInCart(@PathVariable int id, Model model){
		if(cartService.getQuantityByItemId(id) == 0){
			cartService.addItemToCart(id);
		}else {
			cartService.updateItemInCart(id, 1);
		}
	}

	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String checkout(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user", user);
		return "checkout";
	}

}
