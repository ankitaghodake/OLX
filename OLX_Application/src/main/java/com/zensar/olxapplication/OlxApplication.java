package com.zensar.olxapplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zensar.olxapplication.entity.Olx;
@SpringBootApplication
public class OlxApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxApplication.class, args);
	
		 Olx olx=new Olx(); olx.getFirstName();
		 
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
}
