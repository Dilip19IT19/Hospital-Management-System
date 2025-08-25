package com.DYukti.HospitalManagementSystem.controller;

import com.DYukti.HospitalManagementSystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController
{

    private final DoctorService doctorService;

    @GetMapping("/appointment/{doctorId}")
    public ResponseEntity<?> getAllAppointmentsOfDoctor(@PathVariable Long doctorId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getAllAppointmentsOfDoctor(doctorId));
    }
}
