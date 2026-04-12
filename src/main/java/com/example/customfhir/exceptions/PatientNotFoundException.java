package com.example.customfhir.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Long id) {
        super("Patient record not found for id " + id);
    }
}
