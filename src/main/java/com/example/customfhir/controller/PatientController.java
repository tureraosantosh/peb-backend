package com.example.customfhir.controller;

import ca.uhn.fhir.context.FhirContext;
import com.example.customfhir.dto.PatientResponseDto;
import com.example.customfhir.services.PatientRecordService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRecordService service;
    private final FhirContext fhirContext;

    public PatientController(PatientRecordService service, FhirContext fhirContext) {
        this.service = service;
        this.fhirContext = fhirContext;
    }

    @GetMapping
    List<PatientResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    PatientResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/{id}/fhir", produces = "application/fhir+json")
    ResponseEntity<String> findFhirById(@PathVariable Long id) {
        String payload = fhirContext.newJsonParser()
                .setPrettyPrint(true)
                .encodeResourceToString(service.findFhirPatient(id));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/fhir+json"))
                .body(payload);
    }
}
