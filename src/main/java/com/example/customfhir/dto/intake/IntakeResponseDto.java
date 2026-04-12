package com.example.customfhir.dto.intake;

import java.time.OffsetDateTime;
import java.util.List;

public record IntakeResponseDto(
        Long id,
        PractitionerDto practitioner,
        OrderingPractitionerDto orderingPractitioner,
        IntakePatientDto patient,
        AppointmentLocationDto appointmentLocation,
        CoverageDto coverage,
        ProcedureDto procedure,
        List<IcdCodeDto> icdCodes,
        List<ClinicalFileDto> clinicals,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
