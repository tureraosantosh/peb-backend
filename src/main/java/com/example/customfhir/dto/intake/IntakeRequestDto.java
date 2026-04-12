package com.example.customfhir.dto.intake;

import jakarta.validation.Valid;
import java.util.List;

public record IntakeRequestDto(
        @Valid PractitionerDto practitioner,
        @Valid OrderingPractitionerDto orderingPractitioner,
        @Valid IntakePatientDto patient,
        @Valid AppointmentLocationDto appointmentLocation,
        @Valid CoverageDto coverage,
        @Valid ProcedureDto procedure,
        @Valid List<IcdCodeDto> icdCodes
) {
}
