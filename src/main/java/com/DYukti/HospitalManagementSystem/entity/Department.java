package com.DYukti.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department
{
    @Id
    private long id;
    @Column(nullable = false,unique = true)
    private String name;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor headDoctor;
    @ManyToMany
    @JoinTable(
            name = "dept_doctors",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors=new ArrayList<>();
}
