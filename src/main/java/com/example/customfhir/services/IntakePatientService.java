package com.example.customfhir.services;

import com.example.customfhir.dto.IntakePatientRequestDto;
import com.example.customfhir.dto.IntakePatientResponseDto;
import com.example.customfhir.entity.IntakePatientEntity;
import com.example.customfhir.repository.IntakePatientRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IntakePatientService {
    private final IntakePatientRepository repository;
    public IntakePatientService(IntakePatientRepository repository) { this.repository = repository; }
    public List<IntakePatientResponseDto> findAll() { return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList(); }
    public IntakePatientResponseDto findById(Long id) { return toResponse(findEntity(id)); }
    public IntakePatientResponseDto create(IntakePatientRequestDto request) { IntakePatientEntity e = new IntakePatientEntity(); apply(request, e); return toResponse(repository.save(e)); }
    public IntakePatientResponseDto update(Long id, IntakePatientRequestDto request) { IntakePatientEntity e = findEntity(id); apply(request, e); return toResponse(repository.save(e)); }
    public void delete(Long id) { IntakePatientEntity e = findEntity(id); e.setDeleted(true); repository.save(e); }
    private IntakePatientEntity findEntity(Long id) { return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Patient", id)); }
    private void apply(IntakePatientRequestDto r, IntakePatientEntity e) { e.setPatientFirstName(r.patientFirstName()); e.setPatientLastName(r.patientLastName()); e.setPatientId(r.patientId()); e.setDateOfBirth(r.dateOfBirth()); e.setGender(r.gender()); e.setPatientMiddleName(r.patientMiddleName()); e.setPhoneNumber(r.phoneNumber()); e.setStreetAddress(r.streetAddress()); e.setCity(r.city()); e.setState(r.state()); e.setZipCode(r.zipCode()); e.setNotes(r.notes()); }
    private IntakePatientResponseDto toResponse(IntakePatientEntity e) { return new IntakePatientResponseDto(e.getId(), e.getPatientFirstName(), e.getPatientLastName(), e.getPatientId(), e.getDateOfBirth(), e.getGender(), e.getPatientMiddleName(), e.getPhoneNumber(), e.getStreetAddress(), e.getCity(), e.getState(), e.getZipCode(), e.getNotes(), e.getCreatedAt(), e.getUpdatedAt()); }
}

