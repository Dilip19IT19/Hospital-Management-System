package com.DYukti.HospitalManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AppointmentResponse
{
    private Long id;
    private LocalDate appointmentTime;
    private String reason;
    private PatientResponse patientResponse;
    private DoctorResponse doctorResponse;

}
