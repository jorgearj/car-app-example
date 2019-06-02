package com.exercise.carapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class swaggerConfig {
    @Bean
    public Docket carsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.exercise.carapp.controller"))
                .paths(regex("/cars.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Car App Exercise API",
                "Spring Boot REST API for Car management",
                "1.0",
                null,
                new Contact("Jorge Araújo", null, "jorge.arj@gmail.com"),
                null,
                null);
        return apiInfo;
    }
}
