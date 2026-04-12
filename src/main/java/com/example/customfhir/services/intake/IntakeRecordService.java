package com.example.customfhir.services.intake;

import com.example.customfhir.dto.intake.AppointmentLocationDto;
import com.example.customfhir.dto.intake.ClinicalFileDto;
import com.example.customfhir.dto.intake.CoverageDto;
import com.example.customfhir.dto.intake.IcdCodeDto;
import com.example.customfhir.dto.intake.IntakeFieldsResponseDto;
import com.example.customfhir.dto.intake.IntakePatientDto;
import com.example.customfhir.dto.intake.IntakeRequestDto;
import com.example.customfhir.dto.intake.IntakeResponseDto;
import com.example.customfhir.dto.intake.OrderingPractitionerDto;
import com.example.customfhir.dto.intake.PractitionerDto;
import com.example.customfhir.dto.intake.ProcedureDto;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IntakeRecordService {

    private final AtomicLong idGenerator = new AtomicLong(1);
    private final Map<Long, IntakeResponseDto> records = new ConcurrentHashMap<>();

    public List<IntakeResponseDto> findAll() {
        return records.values().stream().toList();
    }

    public IntakeResponseDto findById(Long id) {
        return getOrThrow(id);
    }

    public IntakeResponseDto create(IntakeRequestDto request) {
        Long id = idGenerator.getAndIncrement();
        OffsetDateTime now = OffsetDateTime.now();
        IntakeResponseDto created = new IntakeResponseDto(
                id,
                request.practitioner(),
                request.orderingPractitioner(),
                request.patient(),
                request.appointmentLocation(),
                request.coverage(),
                normalizeProcedure(request.procedure()),
                request.icdCodes() == null ? List.of() : request.icdCodes(),
                List.of(),
                now,
                now
        );
        records.put(id, created);
        return created;
    }

    public IntakeResponseDto update(Long id, IntakeRequestDto request) {
        IntakeResponseDto existing = getOrThrow(id);
        IntakeResponseDto updated = new IntakeResponseDto(
                existing.id(),
                request.practitioner(),
                request.orderingPractitioner(),
                request.patient(),
                request.appointmentLocation(),
                request.coverage(),
                normalizeProcedure(request.procedure()),
                request.icdCodes() == null ? List.of() : request.icdCodes(),
                existing.clinicals(),
                existing.createdAt(),
                OffsetDateTime.now()
        );
        records.put(id, updated);
        return updated;
    }

    public void delete(Long id) {
        if (records.remove(id) == null) {
            throw notFound(id);
        }
    }

    public ClinicalFileDto uploadClinical(Long id, MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Clinical file is required");
        }

        IntakeResponseDto existing = getOrThrow(id);
        ClinicalFileDto uploaded = new ClinicalFileDto(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getSize(),
                OffsetDateTime.now()
        );

        List<ClinicalFileDto> newFiles = new ArrayList<>(existing.clinicals());
        newFiles.add(uploaded);
        IntakeResponseDto updated = new IntakeResponseDto(
                existing.id(),
                existing.practitioner(),
                existing.orderingPractitioner(),
                existing.patient(),
                existing.appointmentLocation(),
                existing.coverage(),
                existing.procedure(),
                existing.icdCodes(),
                List.copyOf(newFiles),
                existing.createdAt(),
                OffsetDateTime.now()
        );
        records.put(id, updated);
        return uploaded;
    }

    public IntakeFieldsResponseDto fields() {
        Map<String, List<String>> resources = new LinkedHashMap<>();
        resources.put("Practitioner", List.of(
                "Physician First Name", "Physician Last Name", "Physician Fax", "Physician Address",
                "Physician City", "Physician State", "Physician NPI", "ZIP Code", "Physician Number",
                "Physician External ID", "Physician TIN"
        ));
        resources.put("Ordering Practitioner", List.of(
                "Ordering Physician First Name", "Ordering Physician Last Name", "Ordering Physician Number",
                "Ordering Physician Fax", "Ordering Physician External ID", "Ordering Physician Address",
                "Ordering Physician City", "Ordering Physician State", "Ordering Physician NPI",
                "Ordering Physician TIN", "Ordering Physician ZIP Code"
        ));
        resources.put("Patient", List.of(
                "Patient First Name", "Patient Last Name", "Patient ID", "Date of Birth", "Gender",
                "Patient Middle Name", "Phone Number", "Street Address", "City", "State", "ZIP Code",
                "Notes (Max 10000 chars)"
        ));
        resources.put("Appointment & Location", List.of(
                "Date of Service Start", "Transaction ID", "Date of Service End", "Facility", "Facility NPI",
                "Facility TIN", "Facility Fax", "Facility Address", "Facility City", "Facility State", "ZIP Code",
                "Admission Type", "Patient Class", "Ordering Facility Name", "Ordering Facility NPI",
                "Ordering Facility Address", "Ordering Facility City", "Ordering Facility State",
                "Ordering Facility ZIP Code", "Ordering Facility Fax", "Ordering Facility Phone",
                "EXP Order-ID", "Appointment Type", "Priority"
        ));
        resources.put("Coverage", List.of(
                "Insurance Type", "Insurance Name", "Member ID", "Group Number", "Group Name", "Phone",
                "Policy Number", "Network Type", "Coverage Status"
        ));
        resources.put("Procedure", List.of(
                "CPT DESCRIPTION", "TEST NAME", "BODY PART", "REQUESTED QUANTITY", "MODIFIER",
                "TEST GROUP NAME", "PLACE OF SERVICE"
        ));
        resources.put("ICD Codes", List.of("ICD Code", "ICD Description"));
        resources.put("Clinicals", List.of("Upload file"));

        return new IntakeFieldsResponseDto(resources);
    }

    private ProcedureDto normalizeProcedure(ProcedureDto procedure) {
        if (procedure == null) {
            return null;
        }
        return procedure.withDefaults();
    }

    private IntakeResponseDto getOrThrow(Long id) {
        IntakeResponseDto response = records.get(id);
        if (response == null) {
            throw notFound(id);
        }
        return response;
    }

    private ResponseStatusException notFound(Long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Intake record not found for id " + id);
    }
}
