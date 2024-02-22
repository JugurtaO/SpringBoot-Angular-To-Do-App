package com.JavaWebLearning.FirstSpringBootCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})

public class FirstSpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootCrudApplication.class, args);

	}





}
