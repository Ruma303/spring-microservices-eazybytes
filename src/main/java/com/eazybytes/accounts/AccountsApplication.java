package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition (
        info = @Info(
                title = "Account microservice REST API",
                description = "Account microservice REST API Documentation",
                version = "1.0",
                contact = @Contact(
                        name = "Eazybytes",
                        url = "https://eazybytes.com"
                ),
                license = @License(
                        name = "Eazybytes",
                        url = "https://eazybytes.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Eazybytes Documentation",
                url = "https://eazybytes.com"
        )
)
public class AccountsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }
}