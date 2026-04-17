package com.example.customfhir.services;

import com.example.customfhir.dto.PatientResponseDto;
import com.example.customfhir.entity.PatientRecord;
import com.example.customfhir.exceptions.PatientNotFoundException;
import com.example.customfhir.repository.PatientRecordRepository;
import java.util.List;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientRecordService {

    private final PatientRecordRepository repository;
    private final PatientFhirMapper fhirMapper;

    public PatientRecordService(PatientRecordRepository repository, PatientFhirMapper fhirMapper) {
        this.repository = repository;
        this.fhirMapper = fhirMapper;
    }

    public List<PatientResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public PatientResponseDto findById(Long id) {
        return toDto(findEntityById(id));
    }

    public Patient findFhirPatient(Long id) {
        return fhirMapper.toFhir(findEntityById(id));
    }

    private PatientRecord findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    private PatientResponseDto toDto(PatientRecord record) {
        return new PatientResponseDto(
                record.getId(),
                record.getMedicalRecordNumber(),
                record.getFirstName(),
                record.getLastName(),
                record.getBirthDate(),
                record.getGender(),
                record.getMiddleName(),
                record.getPhoneNumber(),
                record.getStreetAddress(),
                record.getCity(),
                record.getState(),
                record.getZipCode(),
                record.getNotes()
        );
    }
}
