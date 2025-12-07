package com.studentportal.models.dto;

import com.studentportal.models.Student;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AttendanceDto {

    private Long id;
    private Long studentId;
    private LocalDate date;
    private String status;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private String remarks;

}
