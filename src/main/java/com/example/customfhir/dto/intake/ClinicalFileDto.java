package com.example.customfhir.dto.intake;

import java.time.OffsetDateTime;

public record ClinicalFileDto(
        String fileName,
        String contentType,
        long size,
        OffsetDateTime uploadedAt
) {
}
