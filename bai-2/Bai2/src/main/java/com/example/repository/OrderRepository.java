package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Order;

public interface OrderRepository extends JpaRepository <Order, Long>{
	@Query(value="select * from my_orders o where o.order_number like %:keyword% or o.company_id like %:keyword%", nativeQuery = true)
	public List <Order> checkOrderStatus(String keyword);
}
