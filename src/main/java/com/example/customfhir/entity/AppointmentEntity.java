package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "intake_appointments")
public class AppointmentEntity extends SoftDeletableEntity {
    @Column private OffsetDateTime dateOfServiceStart;
    @Column private String transactionId;
    @Column private OffsetDateTime dateOfServiceEnd;
    @Column private String admissionType;
    @Column private String patientClass;
    @Column private String expOrderId;
    @Column private String appointmentType;
    @Column private String priority;
    public OffsetDateTime getDateOfServiceStart() { return dateOfServiceStart; } public void setDateOfServiceStart(OffsetDateTime v) { dateOfServiceStart = v; }
    public String getTransactionId() { return transactionId; } public void setTransactionId(String v) { transactionId = v; }
    public OffsetDateTime getDateOfServiceEnd() { return dateOfServiceEnd; } public void setDateOfServiceEnd(OffsetDateTime v) { dateOfServiceEnd = v; }
    public String getAdmissionType() { return admissionType; } public void setAdmissionType(String v) { admissionType = v; }
    public String getPatientClass() { return patientClass; } public void setPatientClass(String v) { patientClass = v; }
    public String getExpOrderId() { return expOrderId; } public void setExpOrderId(String v) { expOrderId = v; }
    public String getAppointmentType() { return appointmentType; } public void setAppointmentType(String v) { appointmentType = v; }
    public String getPriority() { return priority; } public void setPriority(String v) { priority = v; }
}

