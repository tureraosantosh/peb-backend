package com.example.customfhir.controller;

import com.example.customfhir.dto.CoverageRequestDto;
import com.example.customfhir.dto.CoverageResponseDto;
import com.example.customfhir.services.CoverageService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coverages")
public class CoverageController {
    private final CoverageService service;
    public CoverageController(CoverageService service) { this.service = service; }
    @GetMapping public List<CoverageResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public CoverageResponseDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public CoverageResponseDto create(@RequestBody CoverageRequestDto request) { return service.create(request); }
    @PutMapping("/{id}") public CoverageResponseDto update(@PathVariable Long id, @RequestBody CoverageRequestDto request) { return service.update(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}

