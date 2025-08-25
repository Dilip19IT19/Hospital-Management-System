package com.DYukti.HospitalManagementSystem.service;

import com.DYukti.HospitalManagementSystem.dto.AppointmentRequest;
import com.DYukti.HospitalManagementSystem.dto.AppointmentResponse;
import com.DYukti.HospitalManagementSystem.dto.PatientRequest;
import com.DYukti.HospitalManagementSystem.dto.PatientResponse;
import com.DYukti.HospitalManagementSystem.entity.Patient;
import com.DYukti.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReceptionistService
{
    private final PatientRepository patientRepository;
    private final AppointmentService appointmentService;

    public Patient createNewPatient(PatientRequest request)
    {
        Patient patient=Patient.builder()
                .name(request.getName())
                .email(request.getEmail())
                .dob(request.getDob())
                .gender(request.getGender())
                .bloodGroup(request.getBloodGroup())
                .build();
        return patientRepository.save(patient);
    }

    public AppointmentResponse createNewAppointmentForPatient(AppointmentRequest request)
    {
        return appointmentService.createAppointment(request);
    }

    public Patient viewPatientByName(String patientName)
    {
        return patientRepository.findByName(patientName).orElseThrow(()->new EntityNotFoundException("No patient found with name : "+patientName));
    }
    public Patient viewPatientById(Long patientId)
    {
        return patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("No patient found with id : "+patientId));
    }


}
