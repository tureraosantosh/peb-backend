package com.example.customfhir.services;

import com.example.customfhir.dto.PractitionerRequestDto;
import com.example.customfhir.dto.PractitionerResponseDto;
import com.example.customfhir.entity.PractitionerEntity;
import com.example.customfhir.repository.PractitionerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PractitionerService {

    private final PractitionerRepository repository;

    public PractitionerService(PractitionerRepository repository) {
        this.repository = repository;
    }

    public List<PractitionerResponseDto> findAll() {
        return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList();
    }

    public PractitionerResponseDto findById(Long id) {
        return toResponse(findEntity(id));
    }

    public PractitionerResponseDto create(PractitionerRequestDto request) {
        PractitionerEntity entity = new PractitionerEntity();
        apply(request, entity);
        return toResponse(repository.save(entity));
    }

    public PractitionerResponseDto update(Long id, PractitionerRequestDto request) {
        PractitionerEntity entity = findEntity(id);
        apply(request, entity);
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        PractitionerEntity entity = findEntity(id);
        entity.setDeleted(true);
        repository.save(entity);
    }

    private PractitionerEntity findEntity(Long id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Practitioner", id));
    }

    private void apply(PractitionerRequestDto request, PractitionerEntity entity) {
        entity.setPhysicianFirstName(request.physicianFirstName());
        entity.setPhysicianLastName(request.physicianLastName());
        entity.setPhysicianFax(request.physicianFax());
        entity.setPhysicianAddress(request.physicianAddress());
        entity.setPhysicianCity(request.physicianCity());
        entity.setPhysicianState(request.physicianState());
        entity.setPhysicianNpi(request.physicianNpi());
        entity.setZipCode(request.zipCode());
        entity.setPhysicianNumber(request.physicianNumber());
        entity.setPhysicianExternalId(request.physicianExternalId());
        entity.setPhysicianTin(request.physicianTin());
    }

    private PractitionerResponseDto toResponse(PractitionerEntity entity) {
        return new PractitionerResponseDto(
                entity.getId(),
                entity.getPhysicianFirstName(),
                entity.getPhysicianLastName(),
                entity.getPhysicianFax(),
                entity.getPhysicianAddress(),
                entity.getPhysicianCity(),
                entity.getPhysicianState(),
                entity.getPhysicianNpi(),
                entity.getZipCode(),
                entity.getPhysicianNumber(),
                entity.getPhysicianExternalId(),
                entity.getPhysicianTin(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

