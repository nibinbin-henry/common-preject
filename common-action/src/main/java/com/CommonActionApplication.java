package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CommonActionApplication {

	public static void main(String[] args) {

		SpringApplication.run(CommonActionApplication.class, args);
		System.out.println("as");
	}
}
