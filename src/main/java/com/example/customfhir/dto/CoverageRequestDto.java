package com.example.customfhir.dto;

import java.time.OffsetDateTime;
public record CoverageRequestDto(String insuranceType,String insuranceName,String memberId,String groupNumber,String groupName,String phone,String policyNumber,String networkType,String coverageStatus) {}

