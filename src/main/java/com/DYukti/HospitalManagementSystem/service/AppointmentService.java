package com.DYukti.HospitalManagementSystem.service;

import com.DYukti.HospitalManagementSystem.dto.AppointmentRequest;
import com.DYukti.HospitalManagementSystem.dto.AppointmentResponse;
import com.DYukti.HospitalManagementSystem.dto.DoctorResponse;
import com.DYukti.HospitalManagementSystem.dto.PatientResponse;
import com.DYukti.HospitalManagementSystem.entity.Appointment;
import com.DYukti.HospitalManagementSystem.entity.Doctor;
import com.DYukti.HospitalManagementSystem.entity.Patient;
import com.DYukti.HospitalManagementSystem.repository.AppointmentRepository;
import com.DYukti.HospitalManagementSystem.repository.DoctorRepository;
import com.DYukti.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class AppointmentService
{
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

//    @Transactional
//    public Appointment createAppointment(Long patientId, Long doctorId, Appointment appointment)
//    {
//        Patient patient=patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with id: "+patientId));
//        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("Doctor not found with id: "+doctorId));
//
//        if(appointment.getId()!=null) throw  new IllegalArgumentException("Appointment id should be empty");
//        else
//        {
//            appointment.setPatient(patient);
//            appointment.setDoctor(doctor);
//
//            patient.getAppointments().add(appointment);
//            doctor.getAppointments().add(appointment);
//
//        }
//        return  appointmentRepository.save(appointment);
//    }

    @Transactional
    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest)
    {
        Patient patient=patientRepository.findById(appointmentRequest.getPatientId()).orElseThrow(()->new EntityNotFoundException("Patient not found with id: "+appointmentRequest.getPatientId()));
        Doctor doctor=doctorRepository.findById(appointmentRequest.getDoctorId()).orElseThrow(()->new EntityNotFoundException("Patient not found with id: "+appointmentRequest.getDoctorId()));
        Appointment appointment=Appointment.builder()
                .appointmentTime(appointmentRequest.getAppointmentTime())
                .doctor(doctor)
                .patient(patient)
                .reason(appointmentRequest.getReason())
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        appointmentRepository.save(appointment);
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

    }

    @Transactional
    public Appointment reassignAppointmentToAnotherDoctor(Long doctorId, Long appointmentId)
    {
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("Doctor not found with id: "+doctorId));
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()->new EntityNotFoundException("Appointment not found with Id : "+appointmentId));
        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);
        return appointment;
    }


}
