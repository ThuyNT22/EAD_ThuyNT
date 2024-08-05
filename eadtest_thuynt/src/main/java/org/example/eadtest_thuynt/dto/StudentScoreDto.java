package org.example.eadtest_thuynt.dto;

public class StudentScoreDto {
    private Long studentId;
    private Long subjectId;
    private double score1;
    private double score2;

    // Constructors, Getters, and Setters
    public StudentScoreDto() {}

    public StudentScoreDto(Long studentId, Long subjectId, double score1, double score2) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score1 = score1;
        this.score2 = score2;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }
}
