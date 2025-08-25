package com.DYukti.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(unique = true, length = 100)
    private String email;
    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    private List<Appointment> appointments=new ArrayList<>();
    @OneToOne(mappedBy = "headDoctor")
    private Department department;
    @ManyToMany(mappedBy = "doctors")
    List<Department> departments=new ArrayList<>();
}
