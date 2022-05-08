/*
 * package com.zensar.olxapplication.swaggerConfig;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Configuration public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.inMemoryAuthentication() .withUser("zensar")
 * .password("zensar@123") .roles("ADMIN") .and() .withUser("Ankita")
 * .password("Ankita123") .roles("USER"); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() {
 * 
 * return NoOpPasswordEncoder.getInstance();
 * 
 * }
 * 
 * }
 */