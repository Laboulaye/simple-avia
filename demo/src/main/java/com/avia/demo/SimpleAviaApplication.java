package com.avia.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Simple Avia API", version = "1.0",
		description = "Rest service which aggregate information about flights and cargo"))
public class SimpleAviaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAviaApplication.class, args);
	}

}
