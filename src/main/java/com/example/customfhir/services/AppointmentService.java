package com.example.customfhir.services;

import com.example.customfhir.dto.*;
import com.example.customfhir.entity.*;
import com.example.customfhir.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;
    public AppointmentService(AppointmentRepository repository) { this.repository = repository; }
    public List<AppointmentResponseDto> findAll() { return repository.findAllByDeletedFalse().stream().map(this::toResponse).toList(); }
    public AppointmentResponseDto findById(Long id) { return toResponse(findEntity(id)); }
    public AppointmentResponseDto create(AppointmentRequestDto request) { AppointmentEntity e = new AppointmentEntity(); apply(request, e); return toResponse(repository.save(e)); }
    public AppointmentResponseDto update(Long id, AppointmentRequestDto request) { AppointmentEntity e = findEntity(id); apply(request, e); return toResponse(repository.save(e)); }
    public void delete(Long id) { AppointmentEntity e = findEntity(id); e.setDeleted(true); repository.save(e); }
    private AppointmentEntity findEntity(Long id) { return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> IntakeErrors.notFound("Appointment", id)); }
    private void apply(AppointmentRequestDto r, AppointmentEntity e) { e.setDateOfServiceStart(r.dateOfServiceStart()); e.setTransactionId(r.transactionId()); e.setDateOfServiceEnd(r.dateOfServiceEnd()); e.setAdmissionType(r.admissionType()); e.setPatientClass(r.patientClass()); e.setExpOrderId(r.expOrderId()); e.setAppointmentType(r.appointmentType()); e.setPriority(r.priority()); e.setFacility(r.facility()); e.setFacilityNpi(r.facilityNpi()); e.setFacilityTin(r.facilityTin()); e.setFacilityFax(r.facilityFax()); e.setFacilityAddress(r.facilityAddress()); e.setFacilityCity(r.facilityCity()); e.setFacilityState(r.facilityState()); e.setZipCode(r.zipCode()); e.setOrderingFacilityName(r.orderingFacilityName()); e.setOrderingFacilityNpi(r.orderingFacilityNpi()); e.setOrderingFacilityAddress(r.orderingFacilityAddress()); e.setOrderingFacilityCity(r.orderingFacilityCity()); e.setOrderingFacilityState(r.orderingFacilityState()); e.setOrderingFacilityZipCode(r.orderingFacilityZipCode()); e.setOrderingFacilityFax(r.orderingFacilityFax()); e.setOrderingFacilityPhone(r.orderingFacilityPhone()); }
    private AppointmentResponseDto toResponse(AppointmentEntity e) { return new AppointmentResponseDto(e.getId(), e.getDateOfServiceStart(), e.getTransactionId(), e.getDateOfServiceEnd(), e.getAdmissionType(), e.getPatientClass(), e.getExpOrderId(), e.getAppointmentType(), e.getPriority(), e.getFacility(), e.getFacilityNpi(), e.getFacilityTin(), e.getFacilityFax(), e.getFacilityAddress(), e.getFacilityCity(), e.getFacilityState(), e.getZipCode(), e.getOrderingFacilityName(), e.getOrderingFacilityNpi(), e.getOrderingFacilityAddress(), e.getOrderingFacilityCity(), e.getOrderingFacilityState(), e.getOrderingFacilityZipCode(), e.getOrderingFacilityFax(), e.getOrderingFacilityPhone(), e.getCreatedAt(), e.getUpdatedAt()); }
}

