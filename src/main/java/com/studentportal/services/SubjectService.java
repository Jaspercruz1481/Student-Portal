package com.studentportal.services;

import com.studentportal.models.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> fetchAllSubjectByStudentId(Long id);
}
