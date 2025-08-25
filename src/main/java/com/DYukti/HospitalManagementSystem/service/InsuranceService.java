package com.DYukti.HospitalManagementSystem.service;

import com.DYukti.HospitalManagementSystem.entity.Insurance;
import com.DYukti.HospitalManagementSystem.entity.Patient;
import com.DYukti.HospitalManagementSystem.repository.InsuranceRepository;
import com.DYukti.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService
{

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Long patientId, Insurance insurance)
    {
        Patient patient=patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with id :"+patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId)
    {
        Patient patient=patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with id :"+patientId));
        patient.setInsurance(null);
        return patient;
    }

}
