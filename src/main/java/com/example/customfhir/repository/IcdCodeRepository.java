package com.example.customfhir.repository;

import com.example.customfhir.entity.IcdCodeEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcdCodeRepository extends JpaRepository<IcdCodeEntity, Long> { List<IcdCodeEntity> findAllByDeletedFalse(); Optional<IcdCodeEntity> findByIdAndDeletedFalse(Long id); }

