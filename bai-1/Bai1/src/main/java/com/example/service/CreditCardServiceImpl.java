package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CreditCard;
import com.example.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard addCreditCard(CreditCard creditCard) {
    	CreditCard existingCard = creditCardRepository.findByCardNumber(creditCard.getCardNumber());
        if (existingCard != null) {
            throw new RuntimeException("Credit card with number " + creditCard.getCardNumber() + " already exists");
        }

        // Save the credit card and return the saved entity
        return creditCardRepository.save(creditCard);
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard getCreditCardById(long id) {
        return creditCardRepository.findById(id).orElse(null);
    }

}
