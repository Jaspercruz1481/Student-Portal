package com.studentportal.resources;

import com.studentportal.models.Grade;
import com.studentportal.models.dto.GradeDto;
import com.studentportal.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradesResource {

    private final GradeService gradeService;

    @Autowired
    public GradesResource(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/list/{studentId}")
    public ResponseEntity<List<GradeDto>> fetchGradesList(@PathVariable Long studentId) {
        List<GradeDto> gradeDtos = gradeService.getByStudentId(studentId);
        return ResponseEntity.ok(gradeDtos);
    }
}
