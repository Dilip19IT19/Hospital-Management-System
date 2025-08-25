package com.DYukti.HospitalManagementSystem.service;

import com.DYukti.HospitalManagementSystem.dto.PatientResponse;
import com.DYukti.HospitalManagementSystem.entity.Patient;
import com.DYukti.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService
{
    private final PatientRepository patientRepository;

    public PatientResponse fetchPatientById(Long patientId)
    {
        Patient patient=patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("No patient found with id: "+patientId));
         return  PatientResponse.builder()
                .name(patient.getName())
                .birthDate(patient.getDob())
                .bloodGroup(patient.getBloodGroup())
                .id(patient.getId())
                .build();

    }

    public List<PatientResponse> fetchAllPatients(Pageable pageable)
    {
        Page<Patient> patientList=patientRepository.findAll(pageable);
        return patientList.stream().map(patient -> {
            return  PatientResponse.builder()
                    .name(patient.getName())
                    .birthDate(patient.getDob())
                    .bloodGroup(patient.getBloodGroup())
                    .id(patient.getId())
                    .build();
        }).collect(Collectors.toList());
    }

}
