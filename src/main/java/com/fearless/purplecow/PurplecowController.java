package com.fearless.purplecow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fearless.purplecow.model.Item;
import com.fearless.purplecow.repository.ItemRepository;
import com.fearless.purplecow.service.MongoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PurplecowController {

	private List<Item> items;

	@Autowired
	private MongoService db;

	public PurplecowController(){
	}

	@GetMapping("/items")
	public List<Item> getItems(){
		return db.findAll();
	}

	@PostMapping("/items")
	public void setItems(@RequestBody List<Item> items) {
		db.saveAll(items);
	}

	@DeleteMapping("/items")
	public void deleteAllItems() {
		db.deleteAll();
	}

}
