package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class FakerBeanConfig {
	
	@Bean
	public Faker getFacker() {
		return new Faker();
	}
}
