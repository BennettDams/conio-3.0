package de.conio.gatewayservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	public AddRequestHeaderFilter addRequestHeaderFilter() {
		return new AddRequestHeaderFilter();
	}
	
	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
}
