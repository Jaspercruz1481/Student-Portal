package com.studentportal.models.dto;

import com.studentportal.models.Course;
import com.studentportal.models.Student;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {

    private Long id;
    private Long studentId;
    private Long courseId;
    private String instructor;
    private String dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String room;
    private String term;
    private String classSection;
}
