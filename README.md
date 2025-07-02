# SchoolBridge API - Repositories and Controllers Overview

This document lists the main JPA repository interfaces and REST controllers needed to manage the entities defined in the SchoolBridge API backend.

---

## Repositories

For each entity that requires CRUD operations, create a Spring Data JPA repository interface:

| Entity               | Repository Interface Name          | Description                                 |
|----------------------|----------------------------------|---------------------------------------------|
| District             | `DistrictRepository`              | Manage districts                            |
| Sector               | `SectorRepository`                | Manage sectors                              |
| Role                 | `RoleRepository`                  | Manage user roles                           |
| DegreeType           | `DegreeTypeRepository`            | Manage degree types                         |
| EducationLevel       | `EducationLevelRepository`        | Manage education levels                     |
| School               | `SchoolRepository`                | Manage schools                             |
| SchoolEducationLevel | `SchoolEducationLevelRepository`  | Link schools to education levels           |
| Bank                 | `BankRepository`                  | Manage banks                               |
| BankAccount          | `BankAccountRepository`           | Manage bank accounts for schools            |
| VerificationType     | `VerificationTypeRepository`      | Manage verification types                   |
| AcademicYear         | `AcademicYearRepository`          | Manage academic years                       |
| User                 | `UserRepository`                  | Manage users                               |
| UserVerification     | `UserVerificationRepository`      | Manage user verifications                   |
| Section              | `SectionRepository`               | Manage sections within education levels    |
| Combination          | `CombinationRepository`           | Manage course combinations                  |
| Course               | `CourseRepository`                | Manage courses                             |
| EducationLevelCourse | `EducationLevelCourseRepository`  | Link courses to education levels            |
| SchoolLevelOffering  | `SchoolLevelOfferingRepository`   | Manage school yearly offerings              |
| SchoolExtraCourse    | `SchoolExtraCourseRepository`     | Manage extra courses in school offerings    |

---

## Controllers

Create REST controllers to expose endpoints for managing the main entities:

| Entity               | Controller Name                   | Notes                                         |
|----------------------|---------------------------------|-----------------------------------------------|
| District             | `DistrictController`             | CRUD for districts                            |
| Sector               | `SectorController`               | CRUD for sectors                              |
| Role                 | `RoleController`                 | User roles management                         |
| DegreeType           | `DegreeTypeController`           | Degree types management                       |
| EducationLevel       | `EducationLevelController`       | Education levels CRUD                         |
| School               | `SchoolController`               | Manage schools                               |
| SchoolEducationLevel | `SchoolEducationLevelController` | Manage school-education level associations   |
| Bank                 | `BankController`                 | CRUD for banks                               |
| BankAccount          | `BankAccountController`          | Manage bank accounts                          |
| VerificationType     | `VerificationTypeController`     | Verification types                           |
| AcademicYear         | `AcademicYearController`         | Academic years management                     |
| User                 | `UserController`                 | User management (registration, profiles)     |
| UserVerification     | `UserVerificationController`     | Manage user verification statuses             |
| Section              | `SectionController`              | Manage education sections                      |
| Combination          | `CombinationController`          | Manage course combinations                     |
| Course               | `CourseController`               | Manage courses                               |
| EducationLevelCourse | `EducationLevelCourseController` | Manage course-education level links           |
| SchoolLevelOffering  | `SchoolLevelOfferingController`  | Manage school yearly offerings                |
| SchoolExtraCourse    | `SchoolExtraCourseController`    | Manage extra courses in school offerings       |

---

## Notes

- Some linking tables (e.g., `SchoolEducationLevel`, `EducationLevelCourse`, `SchoolExtraCourse`) may only require limited endpoints or internal usage.

- You can group related APIs for simplicity, e.g., handle school-related links in `SchoolController` sub-resources.

- For security, restrict write operations on reference data (like roles or degree types) to admin roles only.

- Use DTOs and service layers to decouple API from database entities as needed.

---

## Example Repository Interface

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
    // Custom queries if needed
}

