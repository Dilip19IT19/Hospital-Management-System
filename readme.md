# 🏥 Hospital Management System

A robust and scalable Hospital Management System using **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**. Easily manage patients, appointments, insurance policies, and medical staff through RESTful APIs optimized for real-world healthcare operations.

---

## 🚩 Features

- **Patient Management**
    - Register, view, update, and delete patients
    - Unique constraints on name, email, and DOB
    - Track blood groups and statistics

- **Appointment Scheduling**
    - Patients and doctors linked via appointments
    - Book, view, and manage with date, time, and reason

- **Insurance Integration**
    - Assign/track insurance policies to patients
    - Manage policy number, provider, validity

- **Advanced Search, Pagination & Stats**
    - Filter by blood group, name, DOB, and more
    - Paginated endpoints for large datasets
    - Aggregate statistics on blood group distribution

- **Error Handling & DTO-based Clean API Design**
    - Descriptive responses
    - DTOs for secure, concise data transfer

---

## 🛠️ Technologies Used

- Java 21+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- PostgreSQL (Supabase-compatible)
- Lombok
- Jackson (JSON)
- Maven

---

## 🚀 Getting Started

### Prerequisites

- JDK 21+
- Maven
- PostgreSQL (local or remote)
- Git

### Installation

```
git clone https://github.com/<your-username>/hospital-management-system.git
cd hospital-management-system
mvn clean install

```
### Configuration

Edit `src/main/resources/application.properties`:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.sql.init.mode=always

```
---

### Running
```
mvn spring-boot:run
```
## 📈 API Examples

#### Register Patient
```

POST /receptionist/patient/create
Content-Type: application/json

{
"name": "Richard Lewis",
"email": "richardlewis1935@hotmail.com",
"dob": "1947-06-29",
"gender": "Female",
"bloodGroup": "A_NEGATIVE"
}
```

#### Schedule Appointment

```
POST /receptionist/patient/appointment/create
Content-Type: application/json

{
"patientId": "22",
"doctorId": "1",
"reason": "Installation of pace maker",
"appointmentTime": "2025-11-12T10:45:00"
}
```

---

## 📁 Project Structure

```
src/
├── main/
│ ├── java/
│ │ └── com/
│ │ └── DYukti/
│ │ └── HospitalManagementSystem/
│ │ ├── entity/
│ │ ├── repository/
│ │ ├── service/
│ │ └── controller/
│ └── resources/
│ └── application.properties
├── test/
│ └── (Unit and Integration tests)
```