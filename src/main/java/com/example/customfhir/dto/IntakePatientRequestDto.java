package com.example.customfhir.dto;

import java.time.LocalDate;

public record IntakePatientRequestDto(String patientFirstName,String patientLastName,String patientId,LocalDate dateOfBirth,String gender,String patientMiddleName,String phoneNumber,String streetAddress,String city,String state,String zipCode,String notes) {}

