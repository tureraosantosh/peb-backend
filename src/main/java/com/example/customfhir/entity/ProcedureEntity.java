package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "intake_procedures")
public class ProcedureEntity extends SoftDeletableEntity {
    @Column private String cptDescription;
    @Column private String testName;
    @Column private String bodyPart;
    @Column private Integer requestedQuantity;
    @Column private String modifier;
    @Column private String testGroupName;
    @Column private String placeOfService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private IntakePatientEntity patient;

    public String getCptDescription() { return cptDescription; } public void setCptDescription(String v) { cptDescription = v; }
    public String getTestName() { return testName; } public void setTestName(String v) { testName = v; }
    public String getBodyPart() { return bodyPart; } public void setBodyPart(String v) { bodyPart = v; }
    public Integer getRequestedQuantity() { return requestedQuantity; } public void setRequestedQuantity(Integer v) { requestedQuantity = v; }
    public String getModifier() { return modifier; } public void setModifier(String v) { modifier = v; }
    public String getTestGroupName() { return testGroupName; } public void setTestGroupName(String v) { testGroupName = v; }
    public String getPlaceOfService() { return placeOfService; } public void setPlaceOfService(String v) { placeOfService = v; }
    public IntakePatientEntity getPatient() { return patient; } public void setPatient(IntakePatientEntity p) { this.patient = p; }
}

