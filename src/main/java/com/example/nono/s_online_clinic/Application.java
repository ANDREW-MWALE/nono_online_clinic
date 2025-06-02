package com.example.nono.s_online_clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Removed the commented out ComponentScan
@SpringBootApplication(scanBasePackages = "com.example.nono.s_online_clinic")
public class Application {
	public static void main(String[] args) {
		SpringApplication. run(Application.class, args);
	}	
}
