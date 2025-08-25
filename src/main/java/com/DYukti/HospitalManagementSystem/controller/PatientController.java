package com.DYukti.HospitalManagementSystem.controller;

import com.DYukti.HospitalManagementSystem.dto.AppointmentRequest;
import com.DYukti.HospitalManagementSystem.dto.PatientResponse;
import com.DYukti.HospitalManagementSystem.entity.Patient;
import com.DYukti.HospitalManagementSystem.repository.PatientRepository;
import com.DYukti.HospitalManagementSystem.service.AppointmentService;
import com.DYukti.HospitalManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController
{
//    private final PatientRepository patientRepository;
    private final PatientService patientService;
    private final AppointmentService appointmentService;

//    @GetMapping
//    public Page<Patient> getAllPatients(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "3") int size,
//            @RequestParam(defaultValue = "id") String sortBy,
//            @RequestParam(defaultValue = "true") boolean ascending
//    )
//    {
//        Sort sort=ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable= PageRequest.of(page,size,sort);
//        return patientRepository.fetchAllPatients(pageable);
//    }

    @GetMapping("/{patientId}")
    public ResponseEntity<?> getPatientProfile(@PathVariable Long patientId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.fetchPatientById(patientId));
    }

    @PostMapping("/appointment")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentRequest request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createAppointment(request));
    }

}
