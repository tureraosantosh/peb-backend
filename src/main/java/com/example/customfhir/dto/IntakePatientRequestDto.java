package com.example.customfhir.dto;

import java.time.LocalDate;
import java.util.List;

public record IntakePatientRequestDto(
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
        String notes,
        List<CoverageRequestDto> coverages,
        List<ProcedureRequestDto> procedures
) {}

