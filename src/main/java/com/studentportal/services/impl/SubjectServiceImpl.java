package com.studentportal.services.impl;

import com.studentportal.models.Subject;
import com.studentportal.repos.SubjectRepo;
import com.studentportal.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public List<Subject> fetchAllSubjectByStudentId(Long id) {
        return null;
    }
}
