package com.zensar.olxapplication.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
public class OlxSwaggerConfig {

		@Bean
		public Docket getDocket() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("com.zensar.olxapplication"))
					.build()
					.apiInfo(getOlxApiInfo());
					
		}

		private ApiInfo getOlxApiInfo() {
			
			return new ApiInfo("OlxApplication","GetUser","5.6.6","http://www.zensar.com","AnkitaGhodake"," "," ");
		}
	}
