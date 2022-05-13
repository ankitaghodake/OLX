package com.zensar.spring.repository;

import com.zensar.spring.beans.Product;

public interface ProductRepository {

	public int insertProduct(Product product);

//	public Product displayProduct(int id);

	public String deleteProduct(int id);

	public int updateProduct(int id);

}
