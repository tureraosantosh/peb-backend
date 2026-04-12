package com.example.customfhir.controller;

import com.example.customfhir.dto.ClinicalResponseDto;
import com.example.customfhir.services.ClinicalService;
import java.util.List;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/clinicals")
public class ClinicalController {
    private final ClinicalService service;
    public ClinicalController(ClinicalService service) { this.service = service; }

    @GetMapping public List<ClinicalResponseDto> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public ClinicalResponseDto findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ClinicalResponseDto create(@RequestPart("file") MultipartFile file) { return service.create(file); }

    @PutMapping(path = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ClinicalResponseDto update(@PathVariable Long id, @RequestPart("file") MultipartFile file) { return service.update(id, file); }

    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {
        ClinicalResponseDto meta = service.findById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(meta.fileName()).build().toString())
                .contentType(meta.contentType() == null ? MediaType.APPLICATION_OCTET_STREAM : MediaType.parseMediaType(meta.contentType()))
                .body(service.download(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}

