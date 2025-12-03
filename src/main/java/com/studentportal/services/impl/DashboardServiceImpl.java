package com.studentportal.services.impl;

import com.studentportal.models.Enrollment;
import com.studentportal.models.Grade;
import com.studentportal.models.Schedule;
import com.studentportal.models.Subject;
import com.studentportal.models.dto.AttendanceSummary;
import com.studentportal.models.dto.DashboardDto;
import com.studentportal.models.dto.GradesSummary;
import com.studentportal.models.dto.ScheduleSummary;
import com.studentportal.repos.AttendanceRepo;
import com.studentportal.repos.EnrollmentRepo;
import com.studentportal.repos.GradeRepo;
import com.studentportal.repos.ScheduleRepo;
import com.studentportal.services.DashboardService;
import com.studentportal.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final GradeRepo gradeRepo;
    private final AttendanceRepo attendanceRepo;
    private final ScheduleRepo scheduleRepo;
    private final EnrollmentRepo enrollmentRepo;
    private final GradeService gradeService;
    @Autowired
    public DashboardServiceImpl(GradeRepo gradeRepo, AttendanceRepo attendanceRepo, ScheduleRepo scheduleRepo, EnrollmentRepo enrollmentRepo, GradeService gradeService) {
        this.gradeRepo = gradeRepo;
        this.attendanceRepo = attendanceRepo;
        this.scheduleRepo = scheduleRepo;
        this.enrollmentRepo = enrollmentRepo;
        this.gradeService = gradeService;
    }

    @Override
    public DashboardDto getDashboard(Long studentId) {
        List<Grade> gradesList = gradeRepo.findByStudentId(studentId);
        Double gpa = gradeService.calculateGpa(gradesList, studentId);

        List<String> subjects = gradesList.stream()
                .map(grade -> grade.getSubject().getName()).collect(Collectors.toList());

        GradesSummary gradesSummary = new GradesSummary(gpa, subjects);

        int present = attendanceRepo.countByStudentIdAndStatus(studentId, "PRESENT");
        int absent  = attendanceRepo.countByStudentIdAndStatus(studentId, "ABSENT");
        int late    = attendanceRepo.countByStudentIdAndStatus(studentId, "LATE");

        AttendanceSummary attendanceSummary = new AttendanceSummary(present, absent, late);

        LocalDate today = LocalDate.now();
        List<Schedule> schedules = scheduleRepo.findByStudentId(studentId);

        List<String> classesToday = schedules.stream()
                .filter(s -> s.getStartTime().toLocalDate().equals(today))
                .map(s -> s.getCourse().getCourseName())
                .toList();

        ScheduleSummary scheduleSummary = new ScheduleSummary(classesToday);

        Enrollment enrollment = enrollmentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + studentId));

        return new DashboardDto(
                gradesSummary,
                attendanceSummary,
                scheduleSummary,
                enrollment.getStatus()
        );
    }
}
