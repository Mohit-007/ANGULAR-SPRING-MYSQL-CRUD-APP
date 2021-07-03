package com.app.application.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.repository.ItemRepository;
import com.app.application.entity.Item;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ItemController {

	
	   @Autowired
	   private ItemRepository item_repository ; 
	   
	   @GetMapping(path = "/items", produces= {"application/xml","application/json"})
	   public List<Item> getItems() {
		   return item_repository.findAll();
	   }

		@PostMapping("/item")
		public void addItems(@RequestBody Item item) 
		{
			item_repository.save(item);
		}
			   
		@DeleteMapping("/item/{id}")
		public void addItems(@PathVariable("id") long id) 
		{
			item_repository.deleteById(id);
		}

		
}
