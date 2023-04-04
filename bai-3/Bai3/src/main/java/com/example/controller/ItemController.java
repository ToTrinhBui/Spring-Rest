package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.Item;
import com.example.service.ItemService;

@RestController
@RequestMapping(path = "/", produces = "application/json")
@CrossOrigin(origins = "*")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List <Item> searchItem(@RequestParam(required = false) String keyword){
		List<Item> items = itemService.searchItemByKeyword(keyword);
		if(items == null || items.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Items not found");
        }
        return items;
	}
}
