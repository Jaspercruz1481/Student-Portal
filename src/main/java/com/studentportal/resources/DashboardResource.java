package com.studentportal.resources;

import com.studentportal.models.dto.DashboardDto;
import com.studentportal.services.AttendanceService;
import com.studentportal.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardResource {

    private final DashboardService dashboardService;
    private final AttendanceService attendanceService;

    @Autowired
    public DashboardResource(DashboardService dashboardService, AttendanceService attendanceService) {
        this.dashboardService = dashboardService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/get-attendances/{student-id}")
    public ResponseEntity<String> fetchAttendancesByStudentId() {
        return ResponseEntity.ok("Hi!");
    }

    @GetMapping("/{studentId}")
    public DashboardDto getDashboard(@PathVariable Long studentId) {
        return dashboardService.getDashboard(studentId);
    }
}
