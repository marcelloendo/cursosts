package com.macelloendo.cursosts.domain;

import javax.persistence.Entity;

import com.macelloendo.cursosts.domain.enums.PaymentStatus;

@Entity
public class CardPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallment;

	public CardPayment() {
	}

	public CardPayment(Integer id, PaymentStatus status, Request request, Integer numberOfInstallment) {
		super(id, status, request);
		this.numberOfInstallment = numberOfInstallment;
	}

	public Integer getNumberOfInstallment() {
		return numberOfInstallment;
	}

	public void setNumberOfInstallment(Integer numberOfInstallment) {
		this.numberOfInstallment = numberOfInstallment;
	}

	
}
