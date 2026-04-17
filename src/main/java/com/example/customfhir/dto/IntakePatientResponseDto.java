package com.example.customfhir.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public record IntakePatientResponseDto(
        Long id,
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
        List<CoverageResponseDto> coverages,
        List<ProcedureResponseDto> procedures,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {}

