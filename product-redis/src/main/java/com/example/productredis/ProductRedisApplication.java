package com.example.productredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.productredis.mapper","com.example.productredis.controller",
		"com.example.productredis.service.impl","com.example.productredis.config"})
//@EnableJpaRepositories(basePackages = {"com.example.productredis.repository"})
@EnableCaching
public class ProductRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRedisApplication.class, args);
	}

}
