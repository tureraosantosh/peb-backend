package com.example.customfhir.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnsFhirPatientJsonForSeededRecord() throws Exception {
        mockMvc.perform(get("/patients/1/fhir"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/fhir+json"))
                .andExpect(jsonPath("$.resourceType").value("Patient"))
                .andExpect(jsonPath("$.identifier[0].value").value("MRN-1001"));
    }
}
