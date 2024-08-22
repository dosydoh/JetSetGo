package com.example.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // means class is ready for use by Spring MVC to handle web requests
public class JetSetGoApplication {

	//@GetMapping("/")  //maps / to the index() method. When invoked from a browser or
	//public String index() {    //by using curl on the command line, the method returns pure text.
		//return "Greetings from Spring Boot!";



	public static void main(String[] args) {
		SpringApplication.run(JetSetGoApplication.class, args);
	}

}
