package com.example.customfhir.repository;

import com.example.customfhir.entity.CoverageEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverageRepository extends JpaRepository<CoverageEntity, Long> { List<CoverageEntity> findAllByDeletedFalse(); Optional<CoverageEntity> findByIdAndDeletedFalse(Long id); }

