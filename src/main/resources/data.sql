-- =====================
-- 1. Patients
-- =====================0
INSERT INTO patient (id, name, gender, dob, email, blood_group)
VALUES
(1, 'John Doe', 'Male', '1985-02-15', 'john.doe@example.com', 'A_POSITIVE'),
(2, 'Jane Smith', 'Female', '1990-07-21', 'jane.smith@example.com', 'B_POSITIVE'),
(3, 'Robert Brown', 'Male', '1982-11-10', 'robert.brown@example.com', 'O_NEGATIVE'),
(4, 'Emily Johnson', 'Female', '1995-03-30', 'emily.johnson@example.com', 'AB_POSITIVE'),
(5, 'William Davis', 'Male', '1988-09-12', 'william.davis@example.com', 'A_NEGATIVE'),
(6, 'Sophia Miller', 'Female', '1993-08-05', 'sophia.miller@example.com', 'B_NEGATIVE'),
(7, 'James Wilson', 'Male', '1987-06-14', 'james.wilson@example.com', 'O_POSITIVE'),
(8, 'Olivia Taylor', 'Female', '1991-12-09', 'olivia.taylor@example.com', 'A_POSITIVE'),
(9, 'Daniel Anderson', 'Male', '1986-04-22', 'daniel.anderson@example.com', 'B_POSITIVE'),
(10, 'Mia Thomas', 'Female', '1994-10-02', 'mia.thomas@example.com', 'O_NEGATIVE');

-- =====================
-- 2. Doctors
-- =====================
INSERT INTO doctor (id, name, specialization, email)
VALUES
(1, 'Dr. Alan Carter', 'Cardiology', 'alan.carter@hospital.com'),
(2, 'Dr. Betty Hughes', 'Neurology', 'betty.hughes@hospital.com'),
(3, 'Dr. Charles Young', 'Orthopedics', 'charles.young@hospital.com'),
(4, 'Dr. Diana Scott', 'Pediatrics', 'diana.scott@hospital.com'),
(5, 'Dr. Ethan Moore', 'Dermatology', 'ethan.moore@hospital.com'),
(6, 'Dr. Fiona White', 'Gynecology', 'fiona.white@hospital.com'),
(7, 'Dr. George King', 'Psychiatry', 'george.king@hospital.com'),
(8, 'Dr. Hannah Adams', 'Oncology', 'hannah.adams@hospital.com'),
(9, 'Dr. Ian Brooks', 'Endocrinology', 'ian.brooks@hospital.com'),
(10, 'Dr. Julia Ward', 'Gastroenterology', 'julia.ward@hospital.com');

-- =====================
-- 3. Departments (1-to-1 headDoctor)
-- =====================
INSERT INTO department (id, name, doctor_id)
VALUES
(1, 'Cardiology Dept', 1),
(2, 'Neurology Dept', 2),
(3, 'Orthopedics Dept', 3),
(4, 'Pediatrics Dept', 4),
(5, 'Dermatology Dept', 5),
(6, 'Gynecology Dept', 6),
(7, 'Psychiatry Dept', 7),
(8, 'Oncology Dept', 8),
(9, 'Endocrinology Dept', 9),
(10, 'Gastroenterology Dept', 10);

-- =====================
-- 4. Appointments (Many-to-One to Patient & Doctor)
-- =====================
INSERT INTO appointment (id, appointment_time, reason, patient_id, doctor_id)
VALUES
(1, '2025-08-11 09:00:00', 'Routine Check-up', 1, 1),
(2, '2025-08-11 10:00:00', 'Headache Consultation', 2, 2),
(3, '2025-08-11 11:00:00', 'Knee Pain', 3, 3),
(4, '2025-08-11 12:00:00', 'Child Vaccination', 4, 4),
(5, '2025-08-11 13:00:00', 'Skin Rash', 5, 5),
(6, '2025-08-11 14:00:00', 'Pregnancy Check', 6, 6),
(7, '2025-08-11 15:00:00', 'Depression Counseling', 7, 7),
(8, '2025-08-11 16:00:00', 'Cancer Screening', 8, 8),
(9, '2025-08-11 17:00:00', 'Thyroid Disorder', 9, 9),
(10, '2025-08-11 18:00:00', 'Stomach Pain', 10, 10);

-- =====================
-- 5. Insurance (One-to-One with Patient)
-- =====================
INSERT INTO insurance (id, policy_number, provider, valid_date, created_at, patient_id)
VALUES
(1, 'POL1001', 'HealthCare Inc', '2026-01-01', CURRENT_DATE, 1),
(2, 'POL1002', 'MediLife', '2026-02-01', CURRENT_DATE, 2),
(3, 'POL1003', 'SafeHealth', '2026-03-01', CURRENT_DATE, 3),
(4, 'POL1004', 'GoodCare', '2026-04-01', CURRENT_DATE, 4),
(5, 'POL1005', 'HealthFirst', '2026-05-01', CURRENT_DATE, 5),
(6, 'POL1006', 'PrimeMedi', '2026-06-01', CURRENT_DATE, 6),
(7, 'POL1007', 'LifeShield', '2026-07-01', CURRENT_DATE, 7),
(8, 'POL1008', 'WellCare', '2026-08-01', CURRENT_DATE, 8),
(9, 'POL1009', 'MediTrust', '2026-09-01', CURRENT_DATE, 9),
(10, 'POL1010', 'CarePlus', '2026-10-01', CURRENT_DATE, 10);

-- =====================
-- 6. Many-to-Many Join Table dept_doctors
-- =====================
INSERT INTO dept_doctors (department_id, doctor_id)
VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);
