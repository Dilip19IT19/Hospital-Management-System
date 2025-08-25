package com.DYukti.HospitalManagementSystem.dto;

import com.DYukti.HospitalManagementSystem.type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BloodGroupCountResponse
{
    private BloodGroup bloodGroup;
    private Long count;

}
