package com.DYukti.HospitalManagementSystem.repository;

import com.DYukti.HospitalManagementSystem.dto.BloodGroupCountResponse;
import com.DYukti.HospitalManagementSystem.entity.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class PatientRepositoryTests
{
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @Disabled
    @DisplayName(value = "Find All Patients")
    public void printAllPatientAsJson() throws JsonProcessingException
    {
        List<Patient> patientList =patientRepository.findAllPatientWithInsuranceAndAppointments();
        String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patientList);
        System.out.println("*********************************************************************************");
        System.out.println(json);
    }

    @ParameterizedTest
    @ValueSource(strings = {"John Doe"})
    @DisplayName(value = "Find Patient By Name")
    public void findPatientByName(String name) throws JsonProcessingException {
        Patient patient=patientRepository.findByName(name).orElseThrow(()->new EntityNotFoundException("Patient not found with name : "+name));
        String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patient);
        System.out.println();
        System.out.println("------------------------------------*****************************************----------------------------------");
        System.out.println();
        System.out.println(json);
    }

    @Test
    @DisplayName(value = "Find Patient By Name Or Email")
    public void findPatientByTheirEmailOrDob() throws JsonProcessingException {
        List<Patient> patientList=patientRepository.findByDobOrEmail(LocalDate.parse("1990-07-21"),"sophia.miller@example.com");
        String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patientList);
        System.out.println("------------------------------------*****************************************----------------------------------");
        System.out.println(json);
    }

    @Test
    @DisplayName(value = "Find Patients Born After A Specific Date")
    public void findPatientBornAfterSpecificDate() throws JsonProcessingException {
        List<Patient> patientList=patientRepository.findPatientsBornAfter(LocalDate.parse("1990-07-21"));
        String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patientList);
        System.out.println("------------------------------------*****************************************----------------------------------");
        System.out.println(json);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Robert Brown"})
    @DisplayName(value = "Update Patient Name By Id")
    public void UpdatePatientName(String name) throws JsonProcessingException {
        patientRepository.updatePatientNameById(name,3L);
        Patient patient=patientRepository.findByName(name).orElseThrow(()->new EntityNotFoundException("Patient not found with name : "+name));
        String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patient);
        System.out.println();
        System.out.println("------------------------------------*****************************************----------------------------------");
        System.out.println();
        System.out.println(json);
    }

    @Test
    @DisplayName(value = "Total Patients Per BloodGroup")
    public void countPatientsPerBloodGroup() throws JsonProcessingException {
        List<BloodGroupCountResponse>results=patientRepository.findPatientTotalsPerBloodGroup();
        String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(results);
        System.out.println();
        System.out.println("------------------------------------*****************************************----------------------------------");
        System.out.println();
        System.out.println(json);
    }



}
