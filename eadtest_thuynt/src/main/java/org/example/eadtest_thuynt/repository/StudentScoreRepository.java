package org.example.eadtest_thuynt.repository;

import org.example.eadtest_thuynt.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {
}
