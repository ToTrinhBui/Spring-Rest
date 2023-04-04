package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credit_card")
@Getter
@Setter
@Data
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_card_sequence")
	@SequenceGenerator(name = "credit_card_sequence", sequenceName = "CREDIT_CARD_SEQ")
	private Long id;
	private String cardholderName;
	private String cardType;
	private String cardNumber;
	private String cvc;
	private int expirationMonth;
	private int expirationYear;

	// constructors, getters, setters, equals, hashCode, toString
}