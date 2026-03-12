package com.dauphine.blocker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info= @Info(
				title = "Blogger box backend",
				description = "Backend for the blogger box",
				contact = @Contact(name = "Jules", email = "julesbobo2004@gmail.com"),
				version = "1.0"

		)
)
public class BlockerBoxBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockerBoxBackendApplication.class, args);
	}

}
