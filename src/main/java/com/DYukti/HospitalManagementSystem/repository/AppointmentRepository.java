package com.DYukti.HospitalManagementSystem.repository;

import com.DYukti.HospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
