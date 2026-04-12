package com.example.customfhir.controller;

import com.example.customfhir.dto.IntakePatientRequestDto;
import com.example.customfhir.dto.IntakePatientResponseDto;
import com.example.customfhir.services.IntakePatientService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class IntakePatientController {
    private final IntakePatientService service;
    public IntakePatientController(IntakePatientService service) { this.service = service; }
    @GetMapping public List<IntakePatientResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public IntakePatientResponseDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public IntakePatientResponseDto create(@RequestBody IntakePatientRequestDto request) { return service.create(request); }
    @PutMapping("/{id}") public IntakePatientResponseDto update(@PathVariable Long id, @RequestBody IntakePatientRequestDto request) { return service.update(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}

