package com.DYukti.HospitalManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppointmentRequest
{
    private Long patientId;
    private Long doctorId;
    private String reason;
    private LocalDateTime appointmentTime;
}
