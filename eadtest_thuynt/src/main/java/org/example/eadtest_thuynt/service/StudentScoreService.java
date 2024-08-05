package org.example.eadtest_thuynt.service;

import org.example.eadtest_thuynt.dto.StudentScoreDto;
import java.util.List;

public interface StudentScoreService {
    List<StudentScoreDto> findAllStudentScores();
    StudentScoreDto findStudentScoreById(Long id);
    StudentScoreDto createStudentScore(StudentScoreDto studentScoreDto);
    StudentScoreDto updateStudentScore(Long id, StudentScoreDto studentScoreDto);
    boolean deleteStudentScore(Long id);
}
