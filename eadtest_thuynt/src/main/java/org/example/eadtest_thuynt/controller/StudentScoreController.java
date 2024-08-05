package org.example.eadtest_thuynt.controller;

import org.example.eadtest_thuynt.dto.StudentScoreDto;
import org.example.eadtest_thuynt.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-scores")
public class StudentScoreController {

    @Autowired
    private StudentScoreService studentScoreService;

    @GetMapping
    public List<StudentScoreDto> getAllStudentScores() {
        return studentScoreService.findAllStudentScores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentScoreDto> getStudentScoreById(@PathVariable Long id) {
        StudentScoreDto studentScoreDto = studentScoreService.findStudentScoreById(id);
        if (studentScoreDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentScoreDto);
    }

    @PostMapping
    public ResponseEntity<StudentScoreDto> createStudentScore(@RequestBody StudentScoreDto studentScoreDto) {
        StudentScoreDto createdStudentScore = studentScoreService.createStudentScore(studentScoreDto);
        return ResponseEntity.ok(createdStudentScore);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentScoreDto> updateStudentScore(
            @PathVariable Long id, @RequestBody StudentScoreDto studentScoreDto) {
        StudentScoreDto updatedStudentScore = studentScoreService.updateStudentScore(id, studentScoreDto);
        if (updatedStudentScore == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudentScore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentScore(@PathVariable Long id) {
        boolean isDeleted = studentScoreService.deleteStudentScore(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
