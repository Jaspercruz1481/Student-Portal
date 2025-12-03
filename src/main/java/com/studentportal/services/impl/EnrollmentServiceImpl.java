package com.studentportal.services.impl;

import com.studentportal.commons.DtoMapper;
import com.studentportal.models.Attendance;
import com.studentportal.models.Enrollment;
import com.studentportal.models.dto.AttendanceDto;
import com.studentportal.models.dto.EnrollmentDto;
import com.studentportal.repos.EnrollmentRepo;
import com.studentportal.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepo enrollmentRepo;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepo enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }

    @Override
    public List<EnrollmentDto> getByStudentId(Long studentId) {
        List<Enrollment> byStudentId = enrollmentRepo.findByStudentId(studentId);
        return DtoMapper.mapList(byStudentId, EnrollmentDto.class);
    }
    @Override
    public List<EnrollmentDto> fetchList() {
        List<Enrollment> list = enrollmentRepo.findAll();
        return DtoMapper.mapList(list, EnrollmentDto.class);
    }

    @Override
    public EnrollmentDto getById(Long id) {
        Enrollment enrollment = findById(id);
        return DtoMapper.map(enrollment, EnrollmentDto.class);
    }

    @Override
    public EnrollmentDto createEnrollment(EnrollmentDto dto) {
        Enrollment enrollment = Enrollment.builder()
                .student(dto.getStudent())
                .enrollmentDate(dto.getEnrollmentDate())
                .course(dto.getCourse())
                .term(dto.getTerm())
                .status(dto.getStatus())
                .remarks(dto.getRemarks())
                .build();

        Enrollment save = enrollmentRepo.save(enrollment);
        return DtoMapper.map(save, EnrollmentDto.class);
    }

    @Override
    public EnrollmentDto updateEnrollment(EnrollmentDto dto, Long id) {
        Enrollment enrollment = findById(id);

        enrollment.setStatus(dto.getStatus());
        enrollment.setRemarks(dto.getRemarks());
        enrollment.setStudent(dto.getStudent());
        enrollment.setEnrollmentDate(dto.getEnrollmentDate());
        enrollment.setTerm(dto.getTerm());
        enrollment.setCourse(dto.getCourse());

        Enrollment updated = enrollmentRepo.save(enrollment);

        return DtoMapper.map(updated, EnrollmentDto.class);
    }

    @Override
    public void deleteEnrollment(Long id) {
        Enrollment byId = findById(id);
        enrollmentRepo.delete(byId);
    }

    private Enrollment findById(Long id) {

        return enrollmentRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Enrollment not found with id: " + id)
        );
    }

}
