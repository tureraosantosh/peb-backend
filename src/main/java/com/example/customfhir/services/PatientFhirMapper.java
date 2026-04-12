package com.example.customfhir.services;

import com.example.customfhir.entity.PatientRecord;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientFhirMapper {

    public Patient toFhir(PatientRecord record) {
        Patient patient = new Patient();
        if (record.getId() != null) {
            patient.setId(new IdType("Patient", record.getId()));
        }
        patient.addIdentifier(new Identifier()
                .setSystem("http://hospital.example.org/mrn")
                .setValue(record.getMedicalRecordNumber()));
        patient.addName(new HumanName()
                .setFamily(record.getLastName())
                .addGiven(record.getFirstName()));
        patient.setBirthDate(java.sql.Date.valueOf(record.getBirthDate()));
        patient.setActive(true);
        patient.setGender(Enumerations.AdministrativeGender.UNKNOWN);
        return patient;
    }
}
