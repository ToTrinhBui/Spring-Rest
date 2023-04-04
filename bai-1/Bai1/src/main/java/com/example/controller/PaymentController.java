package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.entity.Payment;
import com.example.service.PaymentService;

@RestController
@RequestMapping(path = "/payment", produces = "application/json")
@CrossOrigin(origins = "*")
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(CreditCardController.class);
	@Autowired
	private PaymentService paymentService;

	@PostMapping(path = "/add", consumes = "application/json")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		try {
			Payment savedPayment = paymentService.addPayment(payment);
			return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
		} catch (Exception ex) {
			logger.error("Error adding credit card: {}", ex.getMessage(), ex);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}

	@GetMapping("/{id}")
	public Payment getPaymentById(@PathVariable("id") Long id) {
		return paymentService.getPaymentById(id);
	}
}
