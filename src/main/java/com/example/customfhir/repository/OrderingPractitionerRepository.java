package com.example.customfhir.repository;

import com.example.customfhir.entity.OrderingPractitionerEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingPractitionerRepository extends JpaRepository<OrderingPractitionerEntity, Long> {
    List<OrderingPractitionerEntity> findAllByDeletedFalse();
    Optional<OrderingPractitionerEntity> findByIdAndDeletedFalse(Long id);
}

