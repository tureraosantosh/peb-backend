package com.example.customfhir.dto;

import java.time.OffsetDateTime;
public record ClinicalResponseDto(Long id,String fileName,String contentType,Long fileSize,OffsetDateTime createdAt,OffsetDateTime updatedAt) {}

