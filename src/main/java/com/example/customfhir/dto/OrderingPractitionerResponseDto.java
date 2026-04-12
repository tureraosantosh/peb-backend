package com.example.customfhir.dto;

import java.time.OffsetDateTime;

public record OrderingPractitionerResponseDto(
        Long id,
        String orderingPhysicianFirstName,
        String orderingPhysicianLastName,
        String orderingPhysicianNumber,
        String orderingPhysicianFax,
        String orderingPhysicianExternalId,
        String orderingPhysicianAddress,
        String orderingPhysicianCity,
        String orderingPhysicianState,
        String orderingPhysicianNpi,
        String orderingPhysicianTin,
        String orderingPhysicianZipCode,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {}

