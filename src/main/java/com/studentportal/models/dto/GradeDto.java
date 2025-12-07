package com.studentportal.models.dto;

import com.studentportal.models.Subject;
import lombok.Data;

@Data
public class GradeDto {

    private Long id;
    private Double midterms;
    private Double finals;
    private Double average;
    private SubjectDto subjectName;
}
