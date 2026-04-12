package com.example.customfhir.services;

import com.example.customfhir.dto.ClinicalResponseDto;
import com.example.customfhir.entity.ClinicalEntity;
import com.example.customfhir.repository.ClinicalRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClinicalService {
    private final ClinicalRepository repository;
    public ClinicalService(ClinicalRepository repository) { this.repository = repository; }

    public List<ClinicalResponseDto> findAll() { return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList(); }
    public ClinicalResponseDto findById(Long id) { return toResponse(findEntity(id)); }
    public ClinicalResponseDto create(MultipartFile file) { ClinicalEntity e = new ClinicalEntity(); applyFile(file, e); return toResponse(repository.save(e)); }
    public ClinicalResponseDto update(Long id, MultipartFile file) { ClinicalEntity e = findEntity(id); applyFile(file, e); return toResponse(repository.save(e)); }
    public byte[] download(Long id) { return findEntity(id).getFileContent(); }
    public void delete(Long id) { ClinicalEntity e = findEntity(id); e.setDeleted(true); repository.save(e); }

    private ClinicalEntity findEntity(Long id) { return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Clinical", id)); }

    private void applyFile(MultipartFile file, ClinicalEntity entity) {
        if (file == null || file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Clinical file is required");
        }
        try {
            entity.setFileName(file.getOriginalFilename());
            entity.setContentType(file.getContentType());
            entity.setFileSize(file.getSize());
            entity.setFileContent(file.getBytes());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to read clinical file", e);
        }
    }

    private ClinicalResponseDto toResponse(ClinicalEntity e) {
        return new ClinicalResponseDto(e.getId(), e.getFileName(), e.getContentType(), e.getFileSize(), e.getCreatedAt(), e.getUpdatedAt());
    }
}

