package com.example.customfhir.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Custom FHIR API")
                .version("v1")
                .description("APIs for patient and intake resources")
                .contact(new Contact().name("Custom FHIR Team"))
                .license(new License().name("Internal Use")));
    }
}
