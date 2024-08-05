package org.example.eadtest_thuynt.service.impl;

import org.example.eadtest_thuynt.entity.Subject;
import org.example.eadtest_thuynt.repository.SubjectRepository;
import org.example.eadtest_thuynt.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Subject findSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    @Transactional
    public Subject updateSubject(Long id, Subject subject) {
        Subject existingSubject = subjectRepository.findById(id).orElse(null);
        if (existingSubject != null) {
            existingSubject.setSubjectCode(subject.getSubjectCode());
            existingSubject.setSubjectName(subject.getSubjectName());
            existingSubject.setCredit(subject.getCredit());
            return subjectRepository.save(existingSubject);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteSubject(Long id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
