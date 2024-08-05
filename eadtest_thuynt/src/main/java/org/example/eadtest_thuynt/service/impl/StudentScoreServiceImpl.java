package org.example.eadtest_thuynt.service.impl;

import org.example.eadtest_thuynt.dto.StudentScoreDto;
import org.example.eadtest_thuynt.entity.Student;
import org.example.eadtest_thuynt.entity.StudentScore;
import org.example.eadtest_thuynt.entity.Subject;
import org.example.eadtest_thuynt.repository.StudentRepository;
import org.example.eadtest_thuynt.repository.StudentScoreRepository;
import org.example.eadtest_thuynt.repository.SubjectRepository;
import org.example.eadtest_thuynt.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentScoreServiceImpl implements StudentScoreService {

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StudentScoreDto> findAllStudentScores() {
        return studentScoreRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public StudentScoreDto findStudentScoreById(Long id) {
        StudentScore studentScore = studentScoreRepository.findById(id).orElse(null);
        return studentScore != null ? convertToDto(studentScore) : null;
    }

    @Override
    @Transactional
    public StudentScoreDto createStudentScore(StudentScoreDto studentScoreDto) {
        Student student = studentRepository.findById(studentScoreDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Subject subject = subjectRepository.findById(studentScoreDto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        StudentScore studentScore = new StudentScore();
        studentScore.setStudent(student);
        studentScore.setSubject(subject);
        studentScore.setScore1(studentScoreDto.getScore1());
        studentScore.setScore2(studentScoreDto.getScore2());

        studentScore = studentScoreRepository.save(studentScore);
        return convertToDto(studentScore);
    }

    @Override
    @Transactional
    public StudentScoreDto updateStudentScore(Long id, StudentScoreDto studentScoreDto) {
        StudentScore studentScore = studentScoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student score not found"));

        studentScore.setScore1(studentScoreDto.getScore1());
        studentScore.setScore2(studentScoreDto.getScore2());

        studentScore = studentScoreRepository.save(studentScore);
        return convertToDto(studentScore);
    }

    @Override
    @Transactional
    public boolean deleteStudentScore(Long id) {
        if (studentScoreRepository.existsById(id)) {
            studentScoreRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private StudentScoreDto convertToDto(StudentScore studentScore) {
        return new StudentScoreDto(
                studentScore.getStudent().getId(),
                studentScore.getSubject().getId(),
                studentScore.getScore1(),
                studentScore.getScore2());
    }
}
