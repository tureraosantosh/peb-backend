package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "intake_clinicals")
@Data
@NoArgsConstructor
public class ClinicalEntity extends SoftDeletableEntity {
    @Column private String fileName;
    @Column private String contentType;
    @Column private Long fileSize;
    @Lob @Column private byte[] fileContent;
}

