package org.biic0.org.repository;

import org.biic0.org.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findStudentByStudentId(String studentId );
}
