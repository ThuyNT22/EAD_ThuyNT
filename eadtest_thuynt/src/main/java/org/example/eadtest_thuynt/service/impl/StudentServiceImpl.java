package org.example.eadtest_thuynt.service.impl;

import org.example.eadtest_thuynt.entity.Student;
import org.example.eadtest_thuynt.repository.StudentRepository;
import org.example.eadtest_thuynt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setStudentCode(student.getStudentCode());
            existingStudent.setFullName(student.getFullName());
            existingStudent.setAddress(student.getAddress());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
