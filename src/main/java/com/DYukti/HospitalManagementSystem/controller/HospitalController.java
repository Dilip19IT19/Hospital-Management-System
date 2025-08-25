package com.DYukti.HospitalManagementSystem.controller;

import com.DYukti.HospitalManagementSystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class HospitalController
{
    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<?> getAllDoctors()
    {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.fetchAllDoctors());
    }
}
