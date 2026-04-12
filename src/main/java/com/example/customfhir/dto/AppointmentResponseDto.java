package com.example.customfhir.dto;

import java.time.OffsetDateTime;
public record AppointmentResponseDto(Long id,OffsetDateTime dateOfServiceStart,String transactionId,OffsetDateTime dateOfServiceEnd,String admissionType,String patientClass,String expOrderId,String appointmentType,String priority,OffsetDateTime createdAt,OffsetDateTime updatedAt) {}

