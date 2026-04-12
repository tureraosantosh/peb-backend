package com.example.customfhir.repository;

import com.example.customfhir.entity.PatientRecord;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {

    Optional<PatientRecord> findByMedicalRecordNumber(String medicalRecordNumber);
}
