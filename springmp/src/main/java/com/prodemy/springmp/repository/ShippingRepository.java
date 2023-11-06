package com.prodemy.springmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodemy.springmp.model.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
