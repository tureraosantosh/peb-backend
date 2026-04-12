package com.example.customfhir.repository;

import com.example.customfhir.entity.ClinicalEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalRepository extends JpaRepository<ClinicalEntity, Long> { List<ClinicalEntity> findAllByDeletedFalse(); Optional<ClinicalEntity> findByIdAndDeletedFalse(Long id); }

