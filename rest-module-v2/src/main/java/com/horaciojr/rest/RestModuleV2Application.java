package com.horaciojr.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.horaciojr"})
public class RestModuleV2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestModuleV2Application.class, args);
	}
	
}
