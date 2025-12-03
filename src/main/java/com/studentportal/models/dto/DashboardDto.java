package com.studentportal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDto {
    private GradesSummary grades;
    private AttendanceSummary attendance;
    private ScheduleSummary todaySchedule;
    private String enrollmentStatus;
}
