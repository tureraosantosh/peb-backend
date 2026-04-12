package com.example.customfhir.repository;

import com.example.customfhir.entity.ProcedureEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> { List<ProcedureEntity> findAllByDeletedFalse(); Optional<ProcedureEntity> findByIdAndDeletedFalse(Long id); }

