package com.example.service;

import java.util.List;

import com.example.entity.Item;

public interface ItemService {
	public List <Item> searchItemByKeyword(String keyword);
}
