package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "intake_clinicals")
public class ClinicalEntity extends SoftDeletableEntity {
    @Column private String fileName;
    @Column private String contentType;
    @Column private Long fileSize;
    @Lob @Column private byte[] fileContent;
    public String getFileName() { return fileName; } public void setFileName(String v) { fileName = v; }
    public String getContentType() { return contentType; } public void setContentType(String v) { contentType = v; }
    public Long getFileSize() { return fileSize; } public void setFileSize(Long v) { fileSize = v; }
    public byte[] getFileContent() { return fileContent; } public void setFileContent(byte[] v) { fileContent = v; }
}

