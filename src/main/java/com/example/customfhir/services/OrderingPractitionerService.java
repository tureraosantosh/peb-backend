package com.example.customfhir.services;

import com.example.customfhir.dto.OrderingPractitionerRequestDto;
import com.example.customfhir.dto.OrderingPractitionerResponseDto;
import com.example.customfhir.entity.OrderingPractitionerEntity;
import com.example.customfhir.repository.OrderingPractitionerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderingPractitionerService {
    private final OrderingPractitionerRepository repository;
    public OrderingPractitionerService(OrderingPractitionerRepository repository) { this.repository = repository; }

    public List<OrderingPractitionerResponseDto> findAll() { return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList(); }
    public OrderingPractitionerResponseDto findById(Long id) { return toResponse(findEntity(id)); }
    public OrderingPractitionerResponseDto create(OrderingPractitionerRequestDto request) { OrderingPractitionerEntity e = new OrderingPractitionerEntity(); apply(request, e); return toResponse(repository.save(e)); }
    public OrderingPractitionerResponseDto update(Long id, OrderingPractitionerRequestDto request) { OrderingPractitionerEntity e = findEntity(id); apply(request, e); return toResponse(repository.save(e)); }
    public void delete(Long id) { OrderingPractitionerEntity e = findEntity(id); e.setDeleted(true); repository.save(e); }

    private OrderingPractitionerEntity findEntity(Long id) { return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Ordering Practitioner", id)); }
    private void apply(OrderingPractitionerRequestDto r, OrderingPractitionerEntity e) {
        e.setOrderingPhysicianFirstName(r.orderingPhysicianFirstName()); e.setOrderingPhysicianLastName(r.orderingPhysicianLastName()); e.setOrderingPhysicianNumber(r.orderingPhysicianNumber());
        e.setOrderingPhysicianFax(r.orderingPhysicianFax()); e.setOrderingPhysicianExternalId(r.orderingPhysicianExternalId()); e.setOrderingPhysicianAddress(r.orderingPhysicianAddress());
        e.setOrderingPhysicianCity(r.orderingPhysicianCity()); e.setOrderingPhysicianState(r.orderingPhysicianState()); e.setOrderingPhysicianNpi(r.orderingPhysicianNpi());
        e.setOrderingPhysicianTin(r.orderingPhysicianTin()); e.setOrderingPhysicianZipCode(r.orderingPhysicianZipCode());
    }
    private OrderingPractitionerResponseDto toResponse(OrderingPractitionerEntity e) {
        return new OrderingPractitionerResponseDto(e.getId(), e.getOrderingPhysicianFirstName(), e.getOrderingPhysicianLastName(), e.getOrderingPhysicianNumber(),
                e.getOrderingPhysicianFax(), e.getOrderingPhysicianExternalId(), e.getOrderingPhysicianAddress(), e.getOrderingPhysicianCity(),
                e.getOrderingPhysicianState(), e.getOrderingPhysicianNpi(), e.getOrderingPhysicianTin(), e.getOrderingPhysicianZipCode(), e.getCreatedAt(), e.getUpdatedAt());
    }
}

