package com.prodemy.springmp.service;

import java.util.List;
import java.util.Optional;

import com.prodemy.springmp.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
    public void addProduct(Product product);
    public void removeProductById(Long id);
    public Optional<Product> getProductById(Long id);
    public List<Product> getAllProductsById(Long id);

}
