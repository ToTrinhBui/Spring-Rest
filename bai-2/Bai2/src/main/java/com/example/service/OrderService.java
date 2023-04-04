package com.example.service;

import java.util.List;

import com.example.entity.Order;

public interface OrderService {
	public List <Order> checkOrderStatusByKeyword(String keyword);
}
