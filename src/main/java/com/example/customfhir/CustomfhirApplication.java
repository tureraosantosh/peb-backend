package com.example.customfhir;

import com.example.customfhir.entity.AppointmentEntity;
import com.example.customfhir.entity.ClinicalEntity;
import com.example.customfhir.entity.CoverageEntity;
import com.example.customfhir.entity.IcdCodeEntity;
import com.example.customfhir.entity.LocationEntity;
import com.example.customfhir.entity.ProcedureEntity;
import com.example.customfhir.entity.PatientRecord;
import com.example.customfhir.entity.PractitionerEntity;
import com.example.customfhir.entity.OrderingPractitionerEntity;
import com.example.customfhir.repository.AppointmentRepository;
import com.example.customfhir.repository.ClinicalRepository;
import com.example.customfhir.repository.CoverageRepository;
import com.example.customfhir.repository.IcdCodeRepository;
import com.example.customfhir.repository.LocationRepository;
import com.example.customfhir.repository.PatientRecordRepository;
import com.example.customfhir.repository.PractitionerRepository;
import com.example.customfhir.repository.ProcedureRepository;
import com.example.customfhir.repository.OrderingPractitionerRepository;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomfhirApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomfhirApplication.class, args);
    }

    @Bean
    CommandLineRunner loadSampleData(
            PatientRecordRepository patientRepository,
            PractitionerRepository practitionerRepository,
            OrderingPractitionerRepository orderingPractitionerRepository,
            AppointmentRepository appointmentRepository,
            LocationRepository locationRepository,
            CoverageRepository coverageRepository,
            ProcedureRepository procedureRepository,
            IcdCodeRepository icdCodeRepository,
            ClinicalRepository clinicalRepository
    ) {
        return args -> {
            if (patientRepository.count() == 0) {
                List<PatientRecord> patients = IntStream.rangeClosed(1, 10)
                        .mapToObj(i -> buildPatient(i))
                        .toList();
                patientRepository.saveAll(patients);

                practitionerRepository.saveAll(List.of(
                        buildPractitioner("John", "Doe", "123-456-7890", "123 Main St", "Anytown", "CA", "1234567890", "12345", "555-1234", "EXT001", "TIN001"),
                        buildPractitioner("Jane", "Smith", "098-765-4321", "456 Elm St", "Othertown", "NY", "0987654321", "67890", "555-5678", "EXT002", "TIN002")
                ));

                orderingPractitionerRepository.saveAll(List.of(
                        buildOrderingPractitioner("Alice", "Johnson", "555-1111", "789 Oak St", "EXT003", "111 Pine St", "Cityville", "TX", "1111111111", "TIN003", "11111"),
                        buildOrderingPractitioner("Bob", "Williams", "555-2222", "222 Maple St", "EXT004", "222 Cedar St", "Township", "FL", "2222222222", "TIN004", "22222")
                ));

                appointmentRepository.saveAll(List.of(
                        buildAppointment("TXN001", "Emergency", "Inpatient", "ORD001", "Consultation", "High", "Main Hospital", "1111111111", "TINH001", "123-456-7890", "Hospital St", "Med City", "MC", "11111", "Ordering Clinic", "2222222222", "Clinic Ave", "Clinic City", "CC", "22222", "098-765-4321", "555-1111"),
                        buildAppointment("TXN002", "Scheduled", "Outpatient", "ORD002", "Checkup", "Normal", "Secondary Hospital", "3333333333", "TINH002", "321-654-0987", "Secondary St", "Sec City", "SC", "33333", "Ordering Lab", "4444444444", "Lab Rd", "Lab City", "LC", "44444", "567-890-1234", "555-2222")
                ));

                locationRepository.saveAll(List.of(
                        buildLocation("Location Hospital", "5555555555", "TINL001", "111-222-3333", "Location St", "Loc City", "LC", "55555", "Ord Loc Clinic", "6666666666", "Ord Loc Ave", "Ord City", "OC", "66666", "444-555-6666", "555-3333")
                ));

                coverageRepository.saveAll(List.of(
                        buildCoverage("Health", "Sample Insurance", "MEM001", "GRP001", "Group A", "555-4001", "POL001", "PPO", "Active"),
                        buildCoverage("Dental", "Dental Ins", "MEM002", "GRP002", "Group B", "555-4002", "POL002", "HMO", "Active")
                ));

                procedureRepository.saveAll(List.of(
                        buildProcedure("Blood Test", "CBC", "Blood", 1, "MOD1", "Hematology", "Lab"),
                        buildProcedure("X-Ray", "Chest X-Ray", "Chest", 1, "MOD2", "Radiology", "Radiology Dept")
                ));

                icdCodeRepository.saveAll(List.of(
                        buildIcdCode("A00", "Cholera"),
                        buildIcdCode("B01", "Varicella")
                ));

                clinicalRepository.saveAll(List.of(
                        buildClinical("sample.pdf", "application/pdf", 1024L, "Sample clinical content".getBytes()),
                        buildClinical("report.docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", 2048L, "Sample report content".getBytes())
                ));
            }
        };
    }

    private static PatientRecord buildPatient(int index) {
        PatientRecord patient = new PatientRecord(
                String.format("MRN-%04d", 1000 + index),
                "Patient",
                String.valueOf(index),
                LocalDate.of(1980 + (index % 20), (index % 12) + 1, (index % 27) + 1)
        );
        patient.setGender(index % 2 == 0 ? "F" : "M");
        patient.setMiddleName("M" + index);
        patient.setPhoneNumber(String.format("555-1%03d", index));
        patient.setStreetAddress(index + " Main St");
        patient.setCity("Patient City " + index);
        patient.setState("ST");
        patient.setZipCode(String.format("%05d", 20000 + index));
        patient.setNotes("Default patient record #" + index);
        return patient;
    }

    private static PractitionerEntity buildPractitioner(String firstName, String lastName, String fax, String address, String city, String state, String npi, String zipCode, String phone, String externalId, String tin) {
        PractitionerEntity entity = new PractitionerEntity();
        entity.setPhysicianFirstName(firstName);
        entity.setPhysicianLastName(lastName);
        entity.setPhysicianFax(fax);
        entity.setPhysicianAddress(address);
        entity.setPhysicianCity(city);
        entity.setPhysicianState(state);
        entity.setPhysicianNpi(npi);
        entity.setZipCode(zipCode);
        entity.setPhysicianNumber(phone);
        entity.setPhysicianExternalId(externalId);
        entity.setPhysicianTin(tin);
        return entity;
    }

    private static OrderingPractitionerEntity buildOrderingPractitioner(String firstName, String lastName, String phone, String fax, String externalId, String address, String city, String state, String npi, String tin, String zipCode) {
        OrderingPractitionerEntity entity = new OrderingPractitionerEntity();
        entity.setOrderingPhysicianFirstName(firstName);
        entity.setOrderingPhysicianLastName(lastName);
        entity.setOrderingPhysicianNumber(phone);
        entity.setOrderingPhysicianFax(fax);
        entity.setOrderingPhysicianExternalId(externalId);
        entity.setOrderingPhysicianAddress(address);
        entity.setOrderingPhysicianCity(city);
        entity.setOrderingPhysicianState(state);
        entity.setOrderingPhysicianNpi(npi);
        entity.setOrderingPhysicianTin(tin);
        entity.setOrderingPhysicianZipCode(zipCode);
        return entity;
    }

    private static AppointmentEntity buildAppointment(String transactionId, String admissionType, String patientClass, String expOrderId, String appointmentType, String priority, String facility, String facilityNpi, String facilityTin, String facilityFax, String facilityAddress, String facilityCity, String facilityState, String zipCode, String orderingFacilityName, String orderingFacilityNpi, String orderingFacilityAddress, String orderingFacilityCity, String orderingFacilityState, String orderingFacilityZipCode, String orderingFacilityFax, String orderingFacilityPhone) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setDateOfServiceStart(OffsetDateTime.now().minusDays(1));
        entity.setTransactionId(transactionId);
        entity.setDateOfServiceEnd(OffsetDateTime.now());
        entity.setAdmissionType(admissionType);
        entity.setPatientClass(patientClass);
        entity.setExpOrderId(expOrderId);
        entity.setAppointmentType(appointmentType);
        entity.setPriority(priority);
        entity.setFacility(facility);
        entity.setFacilityNpi(facilityNpi);
        entity.setFacilityTin(facilityTin);
        entity.setFacilityFax(facilityFax);
        entity.setFacilityAddress(facilityAddress);
        entity.setFacilityCity(facilityCity);
        entity.setFacilityState(facilityState);
        entity.setZipCode(zipCode);
        entity.setOrderingFacilityName(orderingFacilityName);
        entity.setOrderingFacilityNpi(orderingFacilityNpi);
        entity.setOrderingFacilityAddress(orderingFacilityAddress);
        entity.setOrderingFacilityCity(orderingFacilityCity);
        entity.setOrderingFacilityState(orderingFacilityState);
        entity.setOrderingFacilityZipCode(orderingFacilityZipCode);
        entity.setOrderingFacilityFax(orderingFacilityFax);
        entity.setOrderingFacilityPhone(orderingFacilityPhone);
        return entity;
    }

    private static LocationEntity buildLocation(String facility, String facilityNpi, String facilityTin, String facilityFax, String facilityAddress, String facilityCity, String facilityState, String zipCode, String orderingFacilityName, String orderingFacilityNpi, String orderingFacilityAddress, String orderingFacilityCity, String orderingFacilityState, String orderingFacilityZipCode, String orderingFacilityFax, String orderingFacilityPhone) {
        LocationEntity entity = new LocationEntity();
        entity.setFacility(facility);
        entity.setFacilityNpi(facilityNpi);
        entity.setFacilityTin(facilityTin);
        entity.setFacilityFax(facilityFax);
        entity.setFacilityAddress(facilityAddress);
        entity.setFacilityCity(facilityCity);
        entity.setFacilityState(facilityState);
        entity.setZipCode(zipCode);
        entity.setOrderingFacilityName(orderingFacilityName);
        entity.setOrderingFacilityNpi(orderingFacilityNpi);
        entity.setOrderingFacilityAddress(orderingFacilityAddress);
        entity.setOrderingFacilityCity(orderingFacilityCity);
        entity.setOrderingFacilityState(orderingFacilityState);
        entity.setOrderingFacilityZipCode(orderingFacilityZipCode);
        entity.setOrderingFacilityFax(orderingFacilityFax);
        entity.setOrderingFacilityPhone(orderingFacilityPhone);
        return entity;
    }

    private static CoverageEntity buildCoverage(String insuranceType, String insuranceName, String memberId, String groupNumber, String groupName, String phone, String policyNumber, String networkType, String coverageStatus) {
        CoverageEntity entity = new CoverageEntity();
        entity.setInsuranceType(insuranceType);
        entity.setInsuranceName(insuranceName);
        entity.setMemberId(memberId);
        entity.setGroupNumber(groupNumber);
        entity.setGroupName(groupName);
        entity.setPhone(phone);
        entity.setPolicyNumber(policyNumber);
        entity.setNetworkType(networkType);
        entity.setCoverageStatus(coverageStatus);
        return entity;
    }

    private static ProcedureEntity buildProcedure(String cptDescription, String testName, String bodyPart, Integer requestedQuantity, String modifier, String testGroupName, String placeOfService) {
        ProcedureEntity entity = new ProcedureEntity();
        entity.setCptDescription(cptDescription);
        entity.setTestName(testName);
        entity.setBodyPart(bodyPart);
        entity.setRequestedQuantity(requestedQuantity);
        entity.setModifier(modifier);
        entity.setTestGroupName(testGroupName);
        entity.setPlaceOfService(placeOfService);
        return entity;
    }

    private static IcdCodeEntity buildIcdCode(String icdCode, String icdDescription) {
        IcdCodeEntity entity = new IcdCodeEntity();
        entity.setIcdCode(icdCode);
        entity.setIcdDescription(icdDescription);
        return entity;
    }

    private static ClinicalEntity buildClinical(String fileName, String contentType, Long fileSize, byte[] fileContent) {
        ClinicalEntity entity = new ClinicalEntity();
        entity.setFileName(fileName);
        entity.setContentType(contentType);
        entity.setFileSize(fileSize);
        entity.setFileContent(fileContent);
        return entity;
    }
}
