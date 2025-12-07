package com.studentportal.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentDto {

    private Long id;
    private Long studentId;
    private Long courseId;
    private String term;
    private LocalDate enrollmentDate;
    private String status;
    private String remarks;
}
