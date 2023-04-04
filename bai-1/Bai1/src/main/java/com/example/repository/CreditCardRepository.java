package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	@Query(value = "SELECT * FROM credit_card c where c.card_number like %:keyword%", nativeQuery = true)
	public CreditCard findByCardNumber(String keyword);
}
