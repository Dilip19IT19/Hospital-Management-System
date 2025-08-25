package com.DYukti.HospitalManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Insurance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true,nullable = false)
    private String policyNumber;
    @Column(nullable = false)
    private String provider;
    @Column(nullable = false)
    private LocalDate validDate;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDate createdAt;
   @OneToOne
   @JoinColumn(name = "patient_id")
   @JsonBackReference
    private  Patient patient;

}

// Owning side/ child side