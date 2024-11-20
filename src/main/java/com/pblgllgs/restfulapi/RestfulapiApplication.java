package com.pblgllgs.restfulapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot REST API Documentation",
                description = "Spring Boot REST API Description",
                version = "1.0.0",
                contact = @Contact(
                        name = "pblgllgs",
                        email = "pblgllgs@gmail.com",
                        url = "pblgllgs.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "apache.com/licence"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot User Management Documentation",
                url = "pblgllgs.com/user_management"
        )
)
public class RestfulapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulapiApplication.class, args);
    }

}
