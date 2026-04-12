package com.example.customfhir.controller;

import com.example.customfhir.dto.OrderingPractitionerRequestDto;
import com.example.customfhir.dto.OrderingPractitionerResponseDto;
import com.example.customfhir.services.OrderingPractitionerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordering-practitioners")
public class OrderingPractitionerController {
    private final OrderingPractitionerService service;
    public OrderingPractitionerController(OrderingPractitionerService service) { this.service = service; }

    @GetMapping public List<OrderingPractitionerResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public OrderingPractitionerResponseDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public OrderingPractitionerResponseDto create(@RequestBody OrderingPractitionerRequestDto request) { return service.create(request); }
    @PutMapping("/{id}") public OrderingPractitionerResponseDto update(@PathVariable Long id, @RequestBody OrderingPractitionerRequestDto request) { return service.update(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}

