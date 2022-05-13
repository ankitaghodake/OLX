package com.zensar.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.spring.beans.Product;
import com.zensar.spring.repository.ProductRepository;

public class ProductServiceImpl1 implements ProductService {

	private ProductRepository repositoryImpl;

	/*
	 * public ProductServiceImpl1(ProductRepository repository) { System.out.
	 * println("inside public ProductServiceImpl1(ProductRepository repository) !!!"
	 * ); this.repositoryImpl=repository; }
	 */

	public ProductRepository getRepositoryImpl() {
		return repositoryImpl;
	}

	public void setRepositoryImpl(ProductRepository repositoryImpl) {
		System.out.println("inside public void setRepositoryImpl(ProductRepository repositoryImpl !!)");
		this.repositoryImpl = repositoryImpl;
	}

	public int insertProduct(Product product) {

		return repositoryImpl.insertProduct(product);
	}
	/*
	 * public Product displayProduct(int id) { return
	 * repositoryImpl.displayProduct(id); }
	 */

	public String deleteProduct(int id) {
		return repositoryImpl.deleteProduct(id);
	}

	public int updateProduct(int id) {
		return repositoryImpl.updateProduct(id);
	}


	

	@PostConstruct
	public void myInit() {
		System.out.println("inside myInit() !!!");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println(" inside myDestroy()");
	}

	
	
}
