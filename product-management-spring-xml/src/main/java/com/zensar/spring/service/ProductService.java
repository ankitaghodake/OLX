package com.zensar.spring.service;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductService {

	public int insertProduct(Product product);
	//public Product displayProduct(int id);
	public String deleteProduct(int id);
	public int updateProduct(int id);
	
}
