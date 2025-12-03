package com.studentportal.models.dto;

import com.studentportal.models.Course;
import com.studentportal.models.Student;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentDto {

    private Long id;
    private Student student;
    private Course course;
    private String term;
    private LocalDate enrollmentDate;
    private String status;
    private String remarks;
}
