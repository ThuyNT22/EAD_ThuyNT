package org.example.eadtest_thuynt.service;

import org.example.eadtest_thuynt.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAllSubjects();
    Subject findSubjectById(Long id);
    Subject createSubject(Subject subject);
    Subject updateSubject(Long id, Subject subject);
    boolean deleteSubject(Long id);
}
