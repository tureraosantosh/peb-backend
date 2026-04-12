package com.example.customfhir.services;

import com.example.customfhir.dto.IcdCodeRequestDto;
import com.example.customfhir.dto.IcdCodeResponseDto;
import com.example.customfhir.entity.IcdCodeEntity;
import com.example.customfhir.repository.IcdCodeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IcdCodeService {
    private final IcdCodeRepository repository;
    public IcdCodeService(IcdCodeRepository repository) { this.repository = repository; }

    public List<IcdCodeResponseDto> findAll() { return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList(); }
    public IcdCodeResponseDto findById(Long id) { return toResponse(findEntity(id)); }
    public IcdCodeResponseDto create(IcdCodeRequestDto request) { IcdCodeEntity e = new IcdCodeEntity(); apply(request, e); return toResponse(repository.save(e)); }
    public IcdCodeResponseDto update(Long id, IcdCodeRequestDto request) { IcdCodeEntity e = findEntity(id); apply(request, e); return toResponse(repository.save(e)); }
    public void delete(Long id) { IcdCodeEntity e = findEntity(id); e.setDeleted(true); repository.save(e); }

    private IcdCodeEntity findEntity(Long id) { return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("ICD Code", id)); }
    private void apply(IcdCodeRequestDto r, IcdCodeEntity e) { e.setIcdCode(r.icdCode()); e.setIcdDescription(r.icdDescription()); }
    private IcdCodeResponseDto toResponse(IcdCodeEntity e) { return new IcdCodeResponseDto(e.getId(), e.getIcdCode(), e.getIcdDescription(), e.getCreatedAt(), e.getUpdatedAt()); }
}

