package com.example.customfhir.dto;

import java.time.LocalDate;

public record PatientResponseDto(
        Long id,
        String medicalRecordNumber,
        String firstName,
        String lastName,
        LocalDate birthDate
) {
}
