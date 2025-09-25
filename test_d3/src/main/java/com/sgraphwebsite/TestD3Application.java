package com.sgraphwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TestD3Application {

	public static void main(String[] args) {
		SpringApplication.run(TestD3Application.class, args);
	}

}
