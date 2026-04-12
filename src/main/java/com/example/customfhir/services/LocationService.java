package com.example.customfhir.services;

import com.example.customfhir.dto.*;
import com.example.customfhir.entity.*;
import com.example.customfhir.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final LocationRepository repository;
    public LocationService(LocationRepository repository) { this.repository = repository; }
    public List<LocationResponseDto> findAll() { return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList(); }
    public LocationResponseDto findById(Long id) { return toResponse(findEntity(id)); }
    public LocationResponseDto create(LocationRequestDto request) { LocationEntity e = new LocationEntity(); apply(request, e); return toResponse(repository.save(e)); }
    public LocationResponseDto update(Long id, LocationRequestDto request) { LocationEntity e = findEntity(id); apply(request, e); return toResponse(repository.save(e)); }
    public void delete(Long id) { LocationEntity e = findEntity(id); e.setDeleted(true); repository.save(e); }
    private LocationEntity findEntity(Long id) { return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Location", id)); }
    private void apply(LocationRequestDto r, LocationEntity e) { e.setFacility(r.facility()); e.setFacilityNpi(r.facilityNpi()); e.setFacilityTin(r.facilityTin()); e.setFacilityFax(r.facilityFax()); e.setFacilityAddress(r.facilityAddress()); e.setFacilityCity(r.facilityCity()); e.setFacilityState(r.facilityState()); e.setZipCode(r.zipCode()); e.setOrderingFacilityName(r.orderingFacilityName()); e.setOrderingFacilityNpi(r.orderingFacilityNpi()); e.setOrderingFacilityAddress(r.orderingFacilityAddress()); e.setOrderingFacilityCity(r.orderingFacilityCity()); e.setOrderingFacilityState(r.orderingFacilityState()); e.setOrderingFacilityZipCode(r.orderingFacilityZipCode()); e.setOrderingFacilityFax(r.orderingFacilityFax()); e.setOrderingFacilityPhone(r.orderingFacilityPhone()); }
    private LocationResponseDto toResponse(LocationEntity e) { return new LocationResponseDto(e.getId(), e.getFacility(), e.getFacilityNpi(), e.getFacilityTin(), e.getFacilityFax(), e.getFacilityAddress(), e.getFacilityCity(), e.getFacilityState(), e.getZipCode(), e.getOrderingFacilityName(), e.getOrderingFacilityNpi(), e.getOrderingFacilityAddress(), e.getOrderingFacilityCity(), e.getOrderingFacilityState(), e.getOrderingFacilityZipCode(), e.getOrderingFacilityFax(), e.getOrderingFacilityPhone(), e.getCreatedAt(), e.getUpdatedAt()); }
}

