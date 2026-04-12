package com.example.customfhir.dto;

import java.time.OffsetDateTime;
public record LocationResponseDto(Long id,String facility,String facilityNpi,String facilityTin,String facilityFax,String facilityAddress,String facilityCity,String facilityState,String zipCode,String orderingFacilityName,String orderingFacilityNpi,String orderingFacilityAddress,String orderingFacilityCity,String orderingFacilityState,String orderingFacilityZipCode,String orderingFacilityFax,String orderingFacilityPhone,OffsetDateTime createdAt,OffsetDateTime updatedAt) {}

