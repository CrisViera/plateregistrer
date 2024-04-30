package com.example.recar.recar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.example.recar.recar")

public class RecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecarApplication.class, args);
	}

}
