package com.prodemy.springmp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	
    private Long id;
    private String productName;
    private Long categoryId;
    private double productPrice;
    private String productDescription;
    private String imageName;
    
}
