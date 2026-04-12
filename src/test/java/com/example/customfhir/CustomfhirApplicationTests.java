package com.example.customfhir;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.customfhir.repository.PatientRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomfhirApplicationTests {

    @Autowired
    private PatientRecordRepository repository;

    @Test
    void contextLoadsAndSeedsPatientData() {
        assertThat(repository.count()).isGreaterThanOrEqualTo(1);
    }
}
