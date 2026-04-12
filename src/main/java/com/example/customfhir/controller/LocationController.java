package com.example.customfhir.controller;

import com.example.customfhir.dto.LocationRequestDto;
import com.example.customfhir.dto.LocationResponseDto;
import com.example.customfhir.services.LocationService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private final LocationService service;
    public LocationController(LocationService service) { this.service = service; }
    @GetMapping public List<LocationResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public LocationResponseDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public LocationResponseDto create(@RequestBody LocationRequestDto request) { return service.create(request); }
    @PutMapping("/{id}") public LocationResponseDto update(@PathVariable Long id, @RequestBody LocationRequestDto request) { return service.update(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}

