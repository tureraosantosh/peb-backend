package com.example.customfhir.dto;

public record OrderingPractitionerRequestDto(
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
        String orderingPhysicianZipCode
) {}

