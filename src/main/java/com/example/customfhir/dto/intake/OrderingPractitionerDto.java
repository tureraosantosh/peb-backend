package com.example.customfhir.dto.intake;

public record OrderingPractitionerDto(
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
) {
}
