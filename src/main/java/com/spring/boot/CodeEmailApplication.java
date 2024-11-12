package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CodeEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeEmailApplication.class, args);
	}

}
