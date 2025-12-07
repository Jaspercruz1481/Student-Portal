package com.studentportal.resources;

import com.studentportal.models.dto.AttendanceDto;
import com.studentportal.models.dto.EnrollmentDto;
import com.studentportal.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentResource {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentResource(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/list/{studentId}")
    public ResponseEntity<List<EnrollmentDto>> fetchEnrollments(@PathVariable Long studentId) {
        List<EnrollmentDto> byStudentId = enrollmentService.getByStudentId(studentId);
        return ResponseEntity.ok(byStudentId);
    }
}
