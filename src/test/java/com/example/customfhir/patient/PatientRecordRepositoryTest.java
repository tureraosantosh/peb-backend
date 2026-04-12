package com.example.customfhir.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.customfhir.entity.PatientRecord;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PatientRecordRepositoryTest {

    @Autowired
    private PatientRecordRepository repository;

    @Test
    void savesAndFindsPatientByMedicalRecordNumber() {
        PatientRecord saved = repository.save(new PatientRecord(
                "MRN-3001",
                "Chris",
                "Jordan",
                LocalDate.of(1990, 7, 21)
        ));

        assertThat(saved.getId()).isNotNull();
        assertThat(repository.findByMedicalRecordNumber("MRN-3001"))
                .get()
                .extracting(PatientRecord::getLastName)
                .isEqualTo("Jordan");
    }
}
