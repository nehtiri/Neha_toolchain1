package com.hackathon.saarathi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.hackathon.saarathi.springboot")
public class SaarathiApplication {

	public static void main(String[] args) {
		System.out.println("Saarathi Application started");
		SpringApplication.run(SaarathiApplication.class, args);
	}

}

