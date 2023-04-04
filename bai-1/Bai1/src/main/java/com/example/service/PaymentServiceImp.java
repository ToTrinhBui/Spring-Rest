package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CreditCard;
import com.example.entity.Payment;
import com.example.repository.CreditCardRepository;
import com.example.repository.PaymentRepository;

@Service
public class PaymentServiceImp implements PaymentService {
	private final PaymentRepository paymentRepo;
	private final CreditCardRepository creditCardRepo;

	@Autowired
	public PaymentServiceImp(PaymentRepository paymentRepo, CreditCardRepository creditCardRepo) {
		this.paymentRepo = paymentRepo;
		this.creditCardRepo = creditCardRepo;
	}

	@Override
	public Payment addPayment(Payment payment) {
		CreditCard existingCard = creditCardRepo.findByCardNumber(payment.getCreditCardNumber());
		if (existingCard == null) {
            throw new RuntimeException("Credit card with number " + payment.getCreditCardNumber() + " has't been created");
        }
		return paymentRepo.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepo.findAll();
	}

	@Override
	public Payment getPaymentById(long id) {
		return paymentRepo.findById(id).orElse(null);
	}
}
