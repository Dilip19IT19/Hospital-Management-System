package com.DYukti.HospitalManagementSystem.service;

import com.DYukti.HospitalManagementSystem.dto.AppointmentResponse;
import com.DYukti.HospitalManagementSystem.dto.DoctorResponse;
import com.DYukti.HospitalManagementSystem.dto.PatientResponse;
import com.DYukti.HospitalManagementSystem.entity.Appointment;
import com.DYukti.HospitalManagementSystem.entity.Doctor;
import com.DYukti.HospitalManagementSystem.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService
{
    private final DoctorRepository doctorRepository;

    public DoctorResponse fetchDoctorById(Long doctorId)
    {
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("No doctor found with id : "+doctorId));
        return DoctorResponse.builder()
                .email(doctor.getEmail())
                .id(doctor.getId())
                .name(doctor.getName())
                .specialization(doctor.getSpecialization())
                .build();
    }

    public List<DoctorResponse> fetchAllDoctors()
    {
        List<Doctor> doctorList=doctorRepository.findAll();
        return doctorList.stream().map(doctor -> {
            return DoctorResponse.builder()
                    .email(doctor.getEmail())
                    .id(doctor.getId())
                    .name(doctor.getName())
                    .specialization(doctor.getSpecialization())
                    .build();
        }).collect(Collectors.toList());
    }

    public List<AppointmentResponse> getAllAppointmentsOfDoctor(Long doctorId)
    {
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("No doctor found with id : "+doctorId));
        List<Appointment> appointments=doctor.getAppointments();
        return appointments.stream().map(appointment -> {
            return AppointmentResponse.builder()
                    .reason(appointment.getReason())
                    .id(appointment.getId())
                    .doctorResponse(DoctorResponse.builder()
                            .email(appointment.getDoctor().getEmail())
                            .id(appointment.getDoctor().getId())
                            .name(appointment.getDoctor().getName())
                            .specialization(appointment.getDoctor().getSpecialization())
                            .build())
                    .patientResponse(PatientResponse.builder()
                            .birthDate(appointment.getPatient().getDob())
                            .bloodGroup(appointment.getPatient().getBloodGroup())
                            .id(appointment.getPatient().getId())
                            .name(appointment.getPatient().getName())
                            .build())
                    .appointmentTime(appointment.getAppointmentTime().toLocalDate())
                    .build();
        }).collect(Collectors.toList());
    }

}
