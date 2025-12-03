package com.studentportal.services;

import com.studentportal.models.dto.EnrollmentDto;

import java.time.LocalDate;
import java.util.List;

public interface EnrollmentService {

    List<EnrollmentDto> getByStudentId(Long studentId);
    List<EnrollmentDto> fetchList();
    EnrollmentDto getById(Long id);
    EnrollmentDto createEnrollment(EnrollmentDto dto);
    EnrollmentDto updateEnrollment(EnrollmentDto dto, Long id);
    void deleteEnrollment(Long id);
}
