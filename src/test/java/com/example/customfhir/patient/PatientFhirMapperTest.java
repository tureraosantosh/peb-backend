package com.example.customfhir.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.customfhir.entity.PatientRecord;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.hl7.fhir.r4.model.Patient;

class PatientFhirMapperTest {

    private final PatientFhirMapper mapper = new PatientFhirMapper();

    @Test
    void mapsDomainRecordToFhirPatient() {
        PatientRecord record = new PatientRecord("MRN-2001", "Alex", "Taylor", LocalDate.of(1988, 1, 9));
        Patient patient = mapper.toFhir(record);

        assertThat(patient.getIdentifierFirstRep().getValue()).isEqualTo("MRN-2001");
        assertThat(patient.getNameFirstRep().getFamily()).isEqualTo("Taylor");
        assertThat(patient.getNameFirstRep().getGivenAsSingleString()).isEqualTo("Alex");
        assertThat(patient.getBirthDate()).isEqualTo(java.sql.Date.valueOf(LocalDate.of(1988, 1, 9)));
    }
}
