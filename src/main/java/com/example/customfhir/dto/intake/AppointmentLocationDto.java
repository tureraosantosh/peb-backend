package com.example.customfhir.dto.intake;

import java.time.OffsetDateTime;

public record AppointmentLocationDto(
        OffsetDateTime dateOfServiceStart,
        String transactionId,
        OffsetDateTime dateOfServiceEnd,
        String facility,
        String facilityNpi,
        String facilityTin,
        String facilityFax,
        String facilityAddress,
        String facilityCity,
        String facilityState,
        String zipCode,
        String admissionType,
        String patientClass,
        String orderingFacilityName,
        String orderingFacilityNpi,
        String orderingFacilityAddress,
        String orderingFacilityCity,
        String orderingFacilityState,
        String orderingFacilityZipCode,
        String orderingFacilityFax,
        String orderingFacilityPhone,
        String expOrderId,
        String appointmentType,
        String priority
) {
}
