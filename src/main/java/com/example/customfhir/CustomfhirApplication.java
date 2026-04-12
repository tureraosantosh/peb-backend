package com.example.customfhir;

import com.example.customfhir.entity.PatientRecord;
import com.example.customfhir.repository.PatientRecordRepository;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomfhirApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomfhirApplication.class, args);
    }

    @Bean
    CommandLineRunner loadSampleData(PatientRecordRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new PatientRecord(
                        "MRN-1001",
                        "Jane",
                        "Doe",
                        LocalDate.of(1992, 5, 14)
                ));
            }
        };
    }
}
