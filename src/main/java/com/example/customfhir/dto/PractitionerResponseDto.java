package com.example.customfhir.dto;

import java.time.OffsetDateTime;

public record PractitionerResponseDto(
        Long id,
        String physicianFirstName,
        String physicianLastName,
        String physicianFax,
        String physicianAddress,
        String physicianCity,
        String physicianState,
        String physicianNpi,
        String zipCode,
        String physicianNumber,
        String physicianExternalId,
        String physicianTin,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}

