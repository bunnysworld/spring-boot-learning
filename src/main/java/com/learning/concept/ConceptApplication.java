package com.learning.concept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.learning.concept.qualifier	")
@SpringBootApplication
public class ConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConceptApplication.class, args);
	}

}
