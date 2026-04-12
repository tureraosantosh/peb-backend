package com.example.customfhir.repository;

import com.example.customfhir.entity.IntakePatientEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntakePatientRepository extends JpaRepository<IntakePatientEntity, Long> { List<IntakePatientEntity> findAllByDeletedFalse(); Optional<IntakePatientEntity> findByIdAndDeletedFalse(Long id); }

