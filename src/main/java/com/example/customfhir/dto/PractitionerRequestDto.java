package com.example.customfhir.dto;

public record PractitionerRequestDto(
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
        String physicianTin
) {
}

