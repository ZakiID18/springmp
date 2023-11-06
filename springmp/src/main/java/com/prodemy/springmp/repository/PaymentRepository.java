package com.prodemy.springmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodemy.springmp.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
