package com.prodemy.springmp.service;

import java.util.List;
import java.util.Optional;

import com.prodemy.springmp.model.Payment;

public interface PaymentService {
	
	public List<Payment> getAllPayments();
    public void addPayment(Payment payment);
    public void removePaymentById(Long id);
    public Optional<Payment> getPaymentById(Long id);

}
