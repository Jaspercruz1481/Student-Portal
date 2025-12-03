package com.studentportal.services;

import com.studentportal.models.Grade;
import com.studentportal.models.dto.GradeDto;

import java.time.LocalDate;
import java.util.List;

public interface GradeService {

    List<GradeDto> getByStudentId(Long studentId);
    List<GradeDto> fetchList();
    GradeDto getById(Long id);
    GradeDto createGrade(GradeDto dto);
    GradeDto updateGrade(GradeDto dto, Long id);
    void deleteGrade(Long id);
    Double calculateGpa(List<Grade> gradeList, Long studentId);
}
