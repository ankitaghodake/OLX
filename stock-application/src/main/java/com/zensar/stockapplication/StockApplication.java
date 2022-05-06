package com.zensar.stockapplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.zensar.stockapplication.entity.Stock;

@SpringBootApplication
public class StockApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);

		Stock stock = new Stock();
		stock.getStockName();
		stock.getStockId();
		stock.getMarketName();
	
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
