package com.prodemy.springmp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodemy.springmp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
    List<Product> findAllByCategory_Id(Long id);

}
