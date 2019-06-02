package com.exercise.carapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories("com.exercise.carapp.repository")
public class CarAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
	}

}
