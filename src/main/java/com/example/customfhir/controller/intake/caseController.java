package com.example.customfhir.controller.intake;

import com.example.customfhir.dto.intake.ClinicalFileDto;
import com.example.customfhir.dto.intake.IntakeFieldsResponseDto;
import com.example.customfhir.dto.intake.IntakeRequestDto;
import com.example.customfhir.dto.intake.IntakeResponseDto;
import com.example.customfhir.services.intake.IntakeRecordService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/case")
public class caseController {

    private final IntakeRecordService service;

    public caseController(IntakeRecordService service) {
        this.service = service;
    }

    @GetMapping("/fields")
    public IntakeFieldsResponseDto fields() {
        return service.fields();
    }

    @GetMapping
    public List<IntakeResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public IntakeResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IntakeResponseDto create(@Valid @RequestBody IntakeRequestDto request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public IntakeResponseDto update(@PathVariable Long id, @Valid @RequestBody IntakeRequestDto request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(path = "/{id}/clinicals", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public ClinicalFileDto uploadClinical(@PathVariable Long id, @RequestPart("file") MultipartFile file) {
        return service.uploadClinical(id, file);
    }
}
