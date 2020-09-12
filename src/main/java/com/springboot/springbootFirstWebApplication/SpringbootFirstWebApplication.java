package com.springboot.springbootFirstWebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class SpringbootFirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstWebApplication.class, args);
	}

}
