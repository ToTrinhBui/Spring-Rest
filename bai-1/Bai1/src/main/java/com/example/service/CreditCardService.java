package com.example.service;

import java.util.List;

import com.example.entity.CreditCard;

public interface CreditCardService {
    public CreditCard addCreditCard(CreditCard creditCard);
    public List<CreditCard> getAllCreditCards();
    public CreditCard getCreditCardById(long id);
}