package com.DYukti.HospitalManagementSystem.service;

import com.DYukti.HospitalManagementSystem.entity.Insurance;
import com.DYukti.HospitalManagementSystem.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceServiceTest
{
    @Autowired
    private InsuranceService insuranceService;


    @Test
    public void testAssignInsuranceToPatient()
    {
       
        Insurance newInsurance=Insurance.builder().policyNumber("POL10030").provider("TATA AIG").validDate(LocalDate.of(2089,11,17)).build();
        Patient patient= insuranceService.assignInsuranceToPatient(3L,newInsurance);
        System.out.println(patient);
    }
}
