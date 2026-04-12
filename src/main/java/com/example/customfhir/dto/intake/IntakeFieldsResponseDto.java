package com.example.customfhir.dto.intake;

import java.util.List;
import java.util.Map;

public record IntakeFieldsResponseDto(Map<String, List<String>> resources) {
}
