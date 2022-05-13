package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
        
        ProductService service=context.getBean("service",ProductService.class);
        
        Product product=new Product(101,"Mobile",24599);
        service.insertProduct(product);
        System.out.println("inserted successfully!");
        service.deleteProduct(product.getProductId());
        System.out.println("deleted successfully!");
      //  service.displayProduct(product.getProductId());
        service.updateProduct(product.getProductId());
        
        
        
      
        
    }
}
