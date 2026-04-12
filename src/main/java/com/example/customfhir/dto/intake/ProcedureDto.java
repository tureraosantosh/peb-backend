package com.example.customfhir.dto.intake;

public record ProcedureDto(
        String cptDescription,
        String testName,
        String bodyPart,
        Integer requestedQuantity,
        String modifier,
        String testGroupName,
        String placeOfService
) {
    public ProcedureDto withDefaults() {
        return new ProcedureDto(
                cptDescription,
                testName,
                bodyPart,
                requestedQuantity == null ? 1 : requestedQuantity,
                modifier,
                testGroupName,
                placeOfService
        );
    }
}
