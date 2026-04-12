package com.example.customfhir.dto;

import java.time.OffsetDateTime;
public record ProcedureResponseDto(Long id,String cptDescription,String testName,String bodyPart,Integer requestedQuantity,String modifier,String testGroupName,String placeOfService,OffsetDateTime createdAt,OffsetDateTime updatedAt) {}

