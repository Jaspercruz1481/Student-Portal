package com.studentportal.resources;

import com.studentportal.models.dto.AttendanceDto;
import com.studentportal.services.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceResource {

    private final AttendanceService attendanceService;

    public AttendanceResource(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/list/{studentId}")
    public ResponseEntity<List<AttendanceDto>> fetchAttendances(@PathVariable Long studentId) {
        List<AttendanceDto> byStudentId = attendanceService.getByStudentId(studentId);
        return ResponseEntity.ok(byStudentId);
    }
}
