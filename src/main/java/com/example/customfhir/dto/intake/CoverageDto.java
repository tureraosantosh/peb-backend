package com.example.customfhir.dto.intake;

public record CoverageDto(
        String insuranceType,
        String insuranceName,
        String memberId,
        String groupNumber,
        String groupName,
        String phone,
        String policyNumber,
        String networkType,
        String coverageStatus
) {
}
