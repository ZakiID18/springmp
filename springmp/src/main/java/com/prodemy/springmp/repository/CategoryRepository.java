package com.prodemy.springmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodemy.springmp.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
