package com.DYukti.HospitalManagementSystem.controller;

import com.DYukti.HospitalManagementSystem.dto.AppointmentRequest;
import com.DYukti.HospitalManagementSystem.dto.PatientRequest;
import com.DYukti.HospitalManagementSystem.service.ReceptionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receptionist")
@RequiredArgsConstructor
public class ReceptionistController
{
    private final ReceptionistService receptionistService;

    @PostMapping("/patient/create")
    public ResponseEntity<?> createNewPatient(@RequestBody PatientRequest request)
    {
        return  ResponseEntity.status(HttpStatus.CREATED).body(receptionistService.createNewPatient(request));
    }

    @GetMapping("/patient/view")
    public ResponseEntity<?> viewPatientByNameOrId(
            @RequestParam(required = false) String patientName,
            @RequestParam(required = false) Long patientId
    )
    {
        if(patientName!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(receptionistService.viewPatientByName(patientName));
        }
        else if(patientId!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(receptionistService.viewPatientById(patientId));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide either patient name or id");
        }
    }

    @PostMapping("/patient/appointment/create")
    public ResponseEntity<?> createNewAppointmentForPatient(@RequestBody AppointmentRequest request)
    {
        return ResponseEntity.status(HttpStatus.OK).body(receptionistService.createNewAppointmentForPatient(request));
    }
}
