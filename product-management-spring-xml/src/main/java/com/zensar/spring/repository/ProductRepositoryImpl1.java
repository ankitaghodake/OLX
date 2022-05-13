package com.zensar.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	private JdbcTemplate template;
	Product product=new Product();

	public ProductRepositoryImpl1() {

	}

	public int insertProduct(Product product) {
		//createTable();
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		template.execute(sql);
		return 1;
	}
	
	
	
	/*
	 * public Product displayProduct(int id) { String
	 * sql="select * from product where id=?"; return
	 * template.queryForObject(sql,(rs,rowNum) ->{ return new
	 * Product(rs.getInt("productId"),rs.getString("productName"),rs.getInt(
	 * "productCost")); }); }
	 */
	public String deleteProduct(int id) {
		String sql ="delete from product where id=?";
		
		template.update(sql,id);
		
		return "Deleted successfully!!";
	}

	public int updateProduct(int id) {
		if(id==product.getProductId()) {
			String sql = "update product set productName = ?, productCost = ? where productId=?";	
			return template.update(sql, product.getProductName(), product.getProductCost(),product.getProductId());
			
		}
		System.out.println("updated product with "+id);
		return id;
	}
		

	
	
	
	
	
	
	
	
	
	
	
	

	public void createTable() {
		template.execute("create table product(productId int ,productName varchar(50),productCost int)");
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	


	
	
	
	
	

	
	
}
