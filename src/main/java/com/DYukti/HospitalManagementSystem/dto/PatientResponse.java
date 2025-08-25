package com.DYukti.HospitalManagementSystem.dto;

import com.DYukti.HospitalManagementSystem.type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PatientResponse
{
    private Long id;
    private String name;
    private LocalDate birthDate;
    private BloodGroup bloodGroup;

}
