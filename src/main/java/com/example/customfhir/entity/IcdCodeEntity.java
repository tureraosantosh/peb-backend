package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "intake_icd_codes")
@Data
public class IcdCodeEntity extends SoftDeletableEntity {
    @Column private String icdCode;
    @Column private String icdDescription;
}

