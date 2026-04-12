package com.example.customfhir.repository;

import com.example.customfhir.entity.AppointmentEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> { List<AppointmentEntity> findAllByDeletedFalse(); Optional<AppointmentEntity> findByIdAndDeletedFalse(Long id); }

