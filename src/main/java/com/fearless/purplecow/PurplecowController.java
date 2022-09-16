package com.fearless.purplecow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fearless.purplecow.resources.Item;


@RestController
public class PurplecowController {

	private List<Item> items;

	public PurplecowController(){
		this.items = new ArrayList<>();
		Item item1 = new Item(123, "Item_1");
		items.add(item1);
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/items")
	public List<Item> getItems(){
		return this.items;
	}

	@PostMapping("/items")
	public void setItems(@RequestBody List<Item> items) {
		this.items = new ArrayList<Item>(items);
	}

	@DeleteMapping("/items")
	public void deleteAllItems() {
		this.items.clear();
	}

}
