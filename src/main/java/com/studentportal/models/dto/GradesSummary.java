package com.studentportal.models.dto;

import com.studentportal.models.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradesSummary {
    private double gpa;
    private List<String> latestSubjects;
}
