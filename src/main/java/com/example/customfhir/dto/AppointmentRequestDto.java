package com.example.customfhir.dto;

import java.time.OffsetDateTime;
public record AppointmentRequestDto(OffsetDateTime dateOfServiceStart,String transactionId,OffsetDateTime dateOfServiceEnd,String admissionType,String patientClass,String expOrderId,String appointmentType,String priority) {}

