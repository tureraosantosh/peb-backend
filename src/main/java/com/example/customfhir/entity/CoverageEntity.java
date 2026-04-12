package com.example.customfhir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "intake_coverages")
public class CoverageEntity extends SoftDeletableEntity {
    @Column private String insuranceType;
    @Column private String insuranceName;
    @Column private String memberId;
    @Column private String groupNumber;
    @Column private String groupName;
    @Column private String phone;
    @Column private String policyNumber;
    @Column private String networkType;
    @Column private String coverageStatus;
    public String getInsuranceType() { return insuranceType; } public void setInsuranceType(String v) { insuranceType = v; }
    public String getInsuranceName() { return insuranceName; } public void setInsuranceName(String v) { insuranceName = v; }
    public String getMemberId() { return memberId; } public void setMemberId(String v) { memberId = v; }
    public String getGroupNumber() { return groupNumber; } public void setGroupNumber(String v) { groupNumber = v; }
    public String getGroupName() { return groupName; } public void setGroupName(String v) { groupName = v; }
    public String getPhone() { return phone; } public void setPhone(String v) { phone = v; }
    public String getPolicyNumber() { return policyNumber; } public void setPolicyNumber(String v) { policyNumber = v; }
    public String getNetworkType() { return networkType; } public void setNetworkType(String v) { networkType = v; }
    public String getCoverageStatus() { return coverageStatus; } public void setCoverageStatus(String v) { coverageStatus = v; }
}

