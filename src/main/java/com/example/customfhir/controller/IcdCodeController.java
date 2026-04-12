package com.example.customfhir.controller;

import com.example.customfhir.dto.IcdCodeRequestDto;
import com.example.customfhir.dto.IcdCodeResponseDto;
import com.example.customfhir.services.IcdCodeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/icd-codes")
public class IcdCodeController {
    private final IcdCodeService service;
    public IcdCodeController(IcdCodeService service) { this.service = service; }
    @GetMapping public List<IcdCodeResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public IcdCodeResponseDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public IcdCodeResponseDto create(@RequestBody IcdCodeRequestDto request) { return service.create(request); }
    @PutMapping("/{id}") public IcdCodeResponseDto update(@PathVariable Long id, @RequestBody IcdCodeRequestDto request) { return service.update(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}

