package com.DYukti.HospitalManagementSystem.dto;

import com.DYukti.HospitalManagementSystem.type.BloodGroup;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest
{
    private String name;
    private String email;
    private LocalDate dob;
    private String gender;
    private BloodGroup bloodGroup;
}
