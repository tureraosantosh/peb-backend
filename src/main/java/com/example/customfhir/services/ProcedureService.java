package com.example.customfhir.services;

import com.example.customfhir.dto.ProcedureRequestDto;
import com.example.customfhir.dto.ProcedureResponseDto;
import com.example.customfhir.entity.ProcedureEntity;
import com.example.customfhir.repository.ProcedureRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProcedureService {
    private final ProcedureRepository repository;
    public ProcedureService(ProcedureRepository repository) { this.repository = repository; }

    public List<ProcedureResponseDto> findAll() { return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList(); }
    public ProcedureResponseDto findById(Long id) { return toResponse(findEntity(id)); }
    public ProcedureResponseDto create(ProcedureRequestDto request) { ProcedureEntity e = new ProcedureEntity(); apply(request, e); return toResponse(repository.save(e)); }
    public ProcedureResponseDto update(Long id, ProcedureRequestDto request) { ProcedureEntity e = findEntity(id); apply(request, e); return toResponse(repository.save(e)); }
    public void delete(Long id) { ProcedureEntity e = findEntity(id); e.setDeleted(true); repository.save(e); }

    private ProcedureEntity findEntity(Long id) { return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Procedure", id)); }

    private void apply(ProcedureRequestDto r, ProcedureEntity e) {
        e.setCptDescription(r.cptDescription());
        e.setTestName(r.testName());
        e.setBodyPart(r.bodyPart());
        e.setRequestedQuantity(r.requestedQuantity() == null ? 1 : r.requestedQuantity());
        e.setModifier(r.modifier());
        e.setTestGroupName(r.testGroupName());
        e.setPlaceOfService(r.placeOfService());
    }

    private ProcedureResponseDto toResponse(ProcedureEntity e) {
        return new ProcedureResponseDto(e.getId(), e.getCptDescription(), e.getTestName(), e.getBodyPart(), e.getRequestedQuantity(), e.getModifier(), e.getTestGroupName(), e.getPlaceOfService(), e.getCreatedAt(), e.getUpdatedAt());
    }
}

