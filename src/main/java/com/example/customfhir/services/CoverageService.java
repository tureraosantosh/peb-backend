package com.example.customfhir.services;

import com.example.customfhir.dto.*;
import com.example.customfhir.entity.*;
import com.example.customfhir.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CoverageService {
    private final CoverageRepository repository;
    public CoverageService(CoverageRepository repository) { this.repository = repository; }
    public List<CoverageResponseDto> findAll() { return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList(); }
    public CoverageResponseDto findById(Long id) { return toResponse(findEntity(id)); }
    public CoverageResponseDto create(CoverageRequestDto request) { CoverageEntity e = new CoverageEntity(); apply(request, e); return toResponse(repository.save(e)); }
    public CoverageResponseDto update(Long id, CoverageRequestDto request) { CoverageEntity e = findEntity(id); apply(request, e); return toResponse(repository.save(e)); }
    public void delete(Long id) { CoverageEntity e = findEntity(id); e.setDeleted(true); repository.save(e); }
    private CoverageEntity findEntity(Long id) { return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Coverage", id)); }
    private void apply(CoverageRequestDto r, CoverageEntity e) { e.setInsuranceType(r.insuranceType()); e.setInsuranceName(r.insuranceName()); e.setMemberId(r.memberId()); e.setGroupNumber(r.groupNumber()); e.setGroupName(r.groupName()); e.setPhone(r.phone()); e.setPolicyNumber(r.policyNumber()); e.setNetworkType(r.networkType()); e.setCoverageStatus(r.coverageStatus()); }
    private CoverageResponseDto toResponse(CoverageEntity e) { return new CoverageResponseDto(e.getId(), e.getInsuranceType(), e.getInsuranceName(), e.getMemberId(), e.getGroupNumber(), e.getGroupName(), e.getPhone(), e.getPolicyNumber(), e.getNetworkType(), e.getCoverageStatus(), e.getCreatedAt(), e.getUpdatedAt()); }
}

