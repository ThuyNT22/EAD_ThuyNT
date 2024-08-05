package org.example.eadtest_thuynt.service;

import org.example.eadtest_thuynt.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);
}
