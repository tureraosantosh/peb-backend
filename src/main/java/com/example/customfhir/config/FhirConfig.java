package com.example.customfhir.config;

import ca.uhn.fhir.context.FhirContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FhirConfig {

    @Bean
    FhirContext fhirContext() {
        return FhirContext.forR4();
    }
}
