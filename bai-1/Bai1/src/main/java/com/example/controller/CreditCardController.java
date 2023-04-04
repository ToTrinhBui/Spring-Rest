package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CreditCard;
import com.example.service.CreditCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path = "/credit-cards", produces = "application/json")
@CrossOrigin(origins = "*")
public class CreditCardController {
	private static final Logger logger = LoggerFactory.getLogger(CreditCardController.class);
	@Autowired
	private CreditCardService creditCardService;

	@PostMapping(path = "/add", consumes = "application/json")
	public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditCard) {
		try {
			CreditCard newCard = creditCardService.addCreditCard(creditCard);
			return new ResponseEntity<>(newCard, HttpStatus.CREATED);
		} catch (Exception ex) {
			logger.error("Error adding credit card: {}", ex.getMessage(), ex);
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@GetMapping
	public List<CreditCard> getAllCreditCards() {
		return creditCardService.getAllCreditCards();
	}

	@GetMapping("/{id}")
	public CreditCard getCreditCardById(@PathVariable("id") Long id) {
		return creditCardService.getCreditCardById(id);
	}
}
