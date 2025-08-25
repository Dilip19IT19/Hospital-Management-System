package com.DYukti.HospitalManagementSystem.entity;

import com.DYukti.HospitalManagementSystem.type.BloodGroup;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@Table(
       uniqueConstraints = {
               @UniqueConstraint(columnNames = {"emailId"}),
               @UniqueConstraint(columnNames = {"patientName","patientDOB"})
       },
        indexes = {@Index(columnList = "patientDOB")}
)
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@Column(nullable = false,length = 30)
    private String name;
    private String gender;
    private LocalDate dob;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    @OneToOne(mappedBy = "patient",cascade = {CascadeType.ALL},orphanRemoval = true)
    @JsonManagedReference
    private Insurance insurance;
    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Appointment> appointments=new ArrayList<>();

}

