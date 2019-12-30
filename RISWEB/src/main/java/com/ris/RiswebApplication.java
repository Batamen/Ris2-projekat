package com.ris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class RiswebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiswebApplication.class, args);
	}

}
