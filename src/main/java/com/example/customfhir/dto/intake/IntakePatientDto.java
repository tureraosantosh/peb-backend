package com.example.customfhir.dto.intake;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record IntakePatientDto(
        String patientFirstName,
        String patientLastName,
        String patientId,
        LocalDate dateOfBirth,
        String gender,
        String patientMiddleName,
        String phoneNumber,
        String streetAddress,
        String city,
        String state,
        String zipCode,
        @Size(max = 10000) String notes
) {
}
