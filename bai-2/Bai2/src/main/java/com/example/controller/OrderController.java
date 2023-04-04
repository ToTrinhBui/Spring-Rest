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

import com.example.entity.Order;
import com.example.service.OrderService;

@RestController
@RequestMapping(path = "/", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public List <Order> searchItem(@RequestParam(required = false) String keyword){
		List<Order> orders = orderService.checkOrderStatusByKeyword(keyword);
		if(orders == null || orders.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return orders;
	}
}
