package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemRepository itemRepo;
	
	public List<Item> searchItemByKeyword(String keyword){
		if (keyword != null) {
            return itemRepo.searchItem(keyword);
        }
		return itemRepo.findAll();
	}
}
