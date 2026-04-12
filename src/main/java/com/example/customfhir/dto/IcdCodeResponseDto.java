package com.example.customfhir.dto;

import java.time.OffsetDateTime;
public record IcdCodeResponseDto(Long id,String icdCode,String icdDescription,OffsetDateTime createdAt,OffsetDateTime updatedAt) {}

