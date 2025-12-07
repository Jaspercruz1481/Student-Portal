package com.studentportal.models.dto;

import com.studentportal.models.Student;
import lombok.Data;

@Data
public class SubjectDto {

    private Student student;
    private Long id;
    private int units;
    private String description;
    private String name;

}
