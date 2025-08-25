package com.DYukti.HospitalManagementSystem.repository;

import com.DYukti.HospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
