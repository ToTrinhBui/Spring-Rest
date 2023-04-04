package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Order;
import com.example.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepo;
	
	public List<Order> checkOrderStatusByKeyword(String keyword){
		if (keyword != null) {
            return orderRepo.checkOrderStatus(keyword);
        }
		return orderRepo.findAll();
	}
}
