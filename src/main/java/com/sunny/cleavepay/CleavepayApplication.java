package com.sunny.cleavepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
@EnableAutoConfiguration
@SpringBootApplication
public class CleavepayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleavepayApplication.class, args);
	}

}

