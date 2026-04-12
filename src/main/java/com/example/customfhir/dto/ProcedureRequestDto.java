package com.example.customfhir.dto;

import java.time.OffsetDateTime;
public record ProcedureRequestDto(String cptDescription,String testName,String bodyPart,Integer requestedQuantity,String modifier,String testGroupName,String placeOfService) {}

