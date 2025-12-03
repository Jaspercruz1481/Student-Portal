package com.studentportal.models.dto;

import com.studentportal.models.Student;
import com.studentportal.models.Subject;
import lombok.Data;

@Data
public class GradeDto {

    private Long id;
    private Student student;
    private int gradeAmount;
    private Subject subject;
}
