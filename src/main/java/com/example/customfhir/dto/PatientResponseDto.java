package com.example.customfhir.dto;

import java.time.LocalDate;

public record PatientResponseDto(
        Long id,
        String medicalRecordNumber,
        String firstName,
        String lastName,
        LocalDate birthDate,
        String gender,
        String middleName,
        String phoneNumber,
        String streetAddress,
        String city,
        String state,
        String zipCode,
        String notes
) {
}
