package com.example.customfhir.controller;

import com.example.customfhir.dto.AppointmentRequestDto;
import com.example.customfhir.dto.AppointmentResponseDto;
import com.example.customfhir.services.AppointmentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService service;
    public AppointmentController(AppointmentService service) { this.service = service; }
    @GetMapping public List<AppointmentResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public AppointmentResponseDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public AppointmentResponseDto create(@RequestBody AppointmentRequestDto request) { return service.create(request); }
    @PutMapping("/{id}") public AppointmentResponseDto update(@PathVariable Long id, @RequestBody AppointmentRequestDto request) { return service.update(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}

