package com.example.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // means class is ready for use by Spring MVC to handle web requests
public class JetSetGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JetSetGoApplication.class, args);
	}

}
