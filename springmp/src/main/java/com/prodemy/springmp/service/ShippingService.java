package com.prodemy.springmp.service;

import java.util.List;
import java.util.Optional;

import com.prodemy.springmp.model.Shipping;

public interface ShippingService {
	
	public List<Shipping> getAllShippings();
    public void addShipping(Shipping shipping);
    public void removeShippingById(Long id);
    public Optional<Shipping> getShippingById(Long id);

}
