package com.studentportal.resources;

import com.studentportal.models.dto.GradeDto;
import com.studentportal.models.dto.ScheduleDto;
import com.studentportal.repos.ScheduleRepo;
import com.studentportal.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleResource {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleResource(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/list/{studentId}")
    public ResponseEntity<List<ScheduleDto>> fetchGradesList(@PathVariable Long studentId) {
        List<ScheduleDto> byStudentId = scheduleService.getByStudentId(studentId);
        return ResponseEntity.ok(byStudentId);
    }
}
