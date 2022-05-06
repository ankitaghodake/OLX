/*
 * package com.zensar.stockapplication.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import springfox.documentation.RequestHandler; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.service.ApiInfo; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket;
 * 
 * @Configuration public class SwaggerConfig {
 * 
 * @Bean public Docket getDocket() { return new
 * Docket(DocumentationType.SWAGGER_2).select()
 * .apis(RequestHandlerSelectors.basePackage("com.zensar.stockapplication"))
 * .build() .apiInfo(getApiInfo());
 * 
 * 
 * }
 * 
 * private ApiInfo getApiInfo() {
 * 
 * return new
 * ApiInfo("StockApplication","GetStock","5.6.6","http://www.zensar.com",
 * "AnkitaGhodake"," "," "); } }
 */