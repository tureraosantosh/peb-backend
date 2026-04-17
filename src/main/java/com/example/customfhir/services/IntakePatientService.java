package com.example.customfhir.services;

import com.example.customfhir.dto.CoverageRequestDto;
import com.example.customfhir.dto.CoverageResponseDto;
import com.example.customfhir.dto.IntakePatientRequestDto;
import com.example.customfhir.dto.IntakePatientResponseDto;
import com.example.customfhir.dto.ProcedureRequestDto;
import com.example.customfhir.dto.ProcedureResponseDto;
import com.example.customfhir.entity.CoverageEntity;
import com.example.customfhir.entity.IntakePatientEntity;
import com.example.customfhir.entity.ProcedureEntity;
import com.example.customfhir.repository.IntakePatientRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IntakePatientService {
    private final IntakePatientRepository repository;

    public IntakePatientService(IntakePatientRepository repository) { this.repository = repository; }

    public List<IntakePatientResponseDto> findAll() {
        return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList();
    }

    public IntakePatientResponseDto findById(Long id) {
        return toResponse(findEntity(id));
    }

    public IntakePatientResponseDto create(IntakePatientRequestDto request) {
        IntakePatientEntity e = new IntakePatientEntity();
        apply(request, e);
        return toResponse(repository.save(e));
    }

    public IntakePatientResponseDto update(Long id, IntakePatientRequestDto request) {
        IntakePatientEntity e = findEntity(id);
        apply(request, e);
        return toResponse(repository.save(e));
    }

    public void delete(Long id) {
        IntakePatientEntity e = findEntity(id);
        e.setDeleted(true);
        repository.save(e);
    }

    private IntakePatientEntity findEntity(Long id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Patient", id));
    }

    private void apply(IntakePatientRequestDto r, IntakePatientEntity e) {
        e.setPatientFirstName(r.patientFirstName());
        e.setPatientLastName(r.patientLastName());
        e.setPatientId(r.patientId());
        e.setDateOfBirth(r.dateOfBirth());
        e.setGender(r.gender());
        e.setPatientMiddleName(r.patientMiddleName());
        e.setPhoneNumber(r.phoneNumber());
        e.setStreetAddress(r.streetAddress());
        e.setCity(r.city());
        e.setState(r.state());
        e.setZipCode(r.zipCode());
        e.setNotes(r.notes());
        setCoverages(e, r.coverages());
        setProcedures(e, r.procedures());
    }

    private void setCoverages(IntakePatientEntity e, List<CoverageRequestDto> requests) {
        List<CoverageEntity> coverages = new ArrayList<>();
        if (requests != null) {
            for (CoverageRequestDto request : requests) {
                CoverageEntity coverage = new CoverageEntity();
                coverage.setInsuranceType(request.insuranceType());
                coverage.setInsuranceName(request.insuranceName());
                coverage.setMemberId(request.memberId());
                coverage.setGroupNumber(request.groupNumber());
                coverage.setGroupName(request.groupName());
                coverage.setPhone(request.phone());
                coverage.setPolicyNumber(request.policyNumber());
                coverage.setNetworkType(request.networkType());
                coverage.setCoverageStatus(request.coverageStatus());
                coverage.setPatient(e);
                coverages.add(coverage);
            }
        }
        e.getCoverages().clear();
        e.getCoverages().addAll(coverages);
    }

    private void setProcedures(IntakePatientEntity e, List<ProcedureRequestDto> requests) {
        List<ProcedureEntity> procedures = new ArrayList<>();
        if (requests != null) {
            for (ProcedureRequestDto request : requests) {
                ProcedureEntity procedure = new ProcedureEntity();
                procedure.setCptDescription(request.cptDescription());
                procedure.setTestName(request.testName());
                procedure.setBodyPart(request.bodyPart());
                procedure.setRequestedQuantity(request.requestedQuantity());
                procedure.setModifier(request.modifier());
                procedure.setTestGroupName(request.testGroupName());
                procedure.setPlaceOfService(request.placeOfService());
                procedure.setPatient(e);
                procedures.add(procedure);
            }
        }
        e.getProcedures().clear();
        e.getProcedures().addAll(procedures);
    }

    private IntakePatientResponseDto toResponse(IntakePatientEntity e) {
        return new IntakePatientResponseDto(
                e.getId(),
                e.getPatientFirstName(),
                e.getPatientLastName(),
                e.getPatientId(),
                e.getDateOfBirth(),
                e.getGender(),
                e.getPatientMiddleName(),
                e.getPhoneNumber(),
                e.getStreetAddress(),
                e.getCity(),
                e.getState(),
                e.getZipCode(),
                e.getNotes(),
                toCoverageResponses(e.getCoverages()),
                toProcedureResponses(e.getProcedures()),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }

    private List<CoverageResponseDto> toCoverageResponses(List<CoverageEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(entity -> new CoverageResponseDto(
                        entity.getId(),
                        entity.getInsuranceType(),
                        entity.getInsuranceName(),
                        entity.getMemberId(),
                        entity.getGroupNumber(),
                        entity.getGroupName(),
                        entity.getPhone(),
                        entity.getPolicyNumber(),
                        entity.getNetworkType(),
                        entity.getCoverageStatus(),
                        entity.getCreatedAt(),
                        entity.getUpdatedAt()
                ))
                .toList();
    }

    private List<ProcedureResponseDto> toProcedureResponses(List<ProcedureEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(entity -> new ProcedureResponseDto(
                        entity.getId(),
                        entity.getCptDescription(),
                        entity.getTestName(),
                        entity.getBodyPart(),
                        entity.getRequestedQuantity(),
                        entity.getModifier(),
                        entity.getTestGroupName(),
                        entity.getPlaceOfService(),
                        entity.getCreatedAt(),
                        entity.getUpdatedAt()
                ))
                .toList();
    }
}

