package com.example.service;

import java.util.List;

import com.example.entity.Payment;

public interface PaymentService {
	public Payment addPayment(Payment payment);

	public List<Payment> getAllPayments();

	public Payment getPaymentById(long id);
}
