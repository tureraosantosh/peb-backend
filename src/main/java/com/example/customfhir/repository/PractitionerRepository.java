package com.example.customfhir.repository;

import com.example.customfhir.entity.PractitionerEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PractitionerRepository extends JpaRepository<PractitionerEntity, Long> {
    List<PractitionerEntity> findAllByDeletedFalse();
    Optional<PractitionerEntity> findByIdAndDeletedFalse(Long id);
}

