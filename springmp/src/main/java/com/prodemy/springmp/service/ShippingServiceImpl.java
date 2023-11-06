package com.prodemy.springmp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodemy.springmp.model.Shipping;
import com.prodemy.springmp.repository.ShippingRepository;

@Service
public class ShippingServiceImpl implements ShippingService {
	
    @Autowired
    ShippingRepository shippingRepository;
    
    public List<Shipping> getAllShippings(){
        return shippingRepository.findAll();
    }
    public void addShipping(Shipping shipping){
        shippingRepository.save(shipping);
    }
    public void removeShippingById(Long id){
        shippingRepository.deleteById(id);
    }
    public Optional<Shipping> getShippingById(Long id){
        return shippingRepository.findById(id);
    }

}
