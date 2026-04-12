package com.example.customfhir.repository;

import com.example.customfhir.entity.LocationEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> { List<LocationEntity> findAllByDeletedFalse(); Optional<LocationEntity> findByIdAndDeletedFalse(Long id); }

