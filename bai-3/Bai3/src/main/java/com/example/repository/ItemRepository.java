package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Item;

public interface ItemRepository extends JpaRepository <Item, Long>{
	@Query(value="select * from item i where i.name like %:keyword% or i.id like %:keyword%", nativeQuery = true)
	public List <Item> searchItem(String keyword);
}
