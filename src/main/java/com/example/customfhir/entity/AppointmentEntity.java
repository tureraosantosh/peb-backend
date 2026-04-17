package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;

@Entity
@Table(name = "intake_appointments")
@Data
@NoArgsConstructor
public class AppointmentEntity extends SoftDeletableEntity {
    @Column private OffsetDateTime dateOfServiceStart;
    @Column private String transactionId;
    @Column private OffsetDateTime dateOfServiceEnd;
    @Column private String admissionType;
    @Column private String patientClass;
    @Column private String expOrderId;
    @Column private String appointmentType;
    @Column private String priority;
    @Column private String facility;
    @Column private String facilityNpi;
    @Column private String facilityTin;
    @Column private String facilityFax;
    @Column private String facilityAddress;
    @Column private String facilityCity;
    @Column private String facilityState;
    @Column private String zipCode;
    @Column private String orderingFacilityName;
    @Column private String orderingFacilityNpi;
    @Column private String orderingFacilityAddress;
    @Column private String orderingFacilityCity;
    @Column private String orderingFacilityState;
    @Column private String orderingFacilityZipCode;
    @Column private String orderingFacilityFax;
    @Column private String orderingFacilityPhone;
}

