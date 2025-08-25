package com.DYukti.HospitalManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;

@Entity
@Data
@ToString(exclude = {"patient", "doctor"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    @JsonBackReference
    private  Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",nullable = false)
    @JsonIgnore
    private Doctor doctor;


}
