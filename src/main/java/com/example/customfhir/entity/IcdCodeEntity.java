package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "intake_icd_codes")
public class IcdCodeEntity extends SoftDeletableEntity {
    @Column private String icdCode;
    @Column private String icdDescription;
    public String getIcdCode() { return icdCode; } public void setIcdCode(String v) { icdCode = v; }
    public String getIcdDescription() { return icdDescription; } public void setIcdDescription(String v) { icdDescription = v; }
}

