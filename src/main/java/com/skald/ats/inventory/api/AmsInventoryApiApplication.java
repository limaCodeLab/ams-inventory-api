package com.skald.ats.inventory.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.skald.ats.inventory.api")
public class AmsInventoryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsInventoryApiApplication.class, args);
	}

}
