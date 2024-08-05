package org.example.eadtest_thuynt.repository;

import org.example.eadtest_thuynt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
