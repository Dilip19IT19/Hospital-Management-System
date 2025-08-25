package com.DYukti.HospitalManagementSystem.repository;

import com.DYukti.HospitalManagementSystem.dto.BloodGroupCountResponse;
import com.DYukti.HospitalManagementSystem.entity.Patient;
import com.DYukti.HospitalManagementSystem.type.BloodGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long>
{
    Optional<Patient> findByName(String name);
    List<Patient> findByDobOrEmail(LocalDate dob,String email);
    List<Patient> findByNameOrderByIdAsc(String patientName);
    @Query("select p from Patient p where p.bloodGroup= ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup")BloodGroup bloodGroup);
    @Query("select p from Patient p where p.dob > :date")
    List<Patient> findPatientsBornAfter(@Param("date") LocalDate date);
    @Query(value = "select * from patient",nativeQuery = true)
    List<Patient> findAllPatients();
    @Transactional
    @Modifying
    @Query("update Patient p set p.name= :name where p.id= :id")
    void updatePatientNameById(@Param("name") String name,@Param("id") Long id);
    @Query("select new com.DYukti.HospitalManagementSystem.dto.BloodGroupCountResponse(p.bloodGroup,count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupCountResponse> findPatientTotalsPerBloodGroup();
    @Query("select distinct p from Patient p left join fetch p.insurance left join fetch p.appointments order by p.id")
    List<Patient> findAllPatientWithInsuranceAndAppointments();
    @Query(value = "select * from patient",nativeQuery = true)
    Page<Patient> fetchAllPatients(Pageable pageable);
    @Query(value = "select * from patient where name= patientName or id=patientId",nativeQuery = true)
    Optional<Patient> findByNameOrId(@Param("patientName")String patientName,@Param("patientId") Long patientId);


}
