package com.example.customfhir.controller;

import com.example.customfhir.dto.ProcedureRequestDto;
import com.example.customfhir.dto.ProcedureResponseDto;
import com.example.customfhir.services.ProcedureService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/procedures")
public class ProcedureController {
    private final ProcedureService service;
    public ProcedureController(ProcedureService service) { this.service = service; }
    @GetMapping public List<ProcedureResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public ProcedureResponseDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public ProcedureResponseDto create(@RequestBody ProcedureRequestDto request) { return service.create(request); }
    @PutMapping("/{id}") public ProcedureResponseDto update(@PathVariable Long id, @RequestBody ProcedureRequestDto request) { return service.update(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}

