package com.zensar.olxmasterappplication.olxmasterconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
public class MasterConfig {

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.zensar"))
				.build()
				.apiInfo(getOlxMasterInfo());
				
		
	}

	private ApiInfo getOlxMasterInfo() {
		
		return new ApiInfo("MasterOlxApplication","GetOlxMaster","5.6.6","http://www.zensar.com","AnkitaGhodake"," "," ");
	}
}
