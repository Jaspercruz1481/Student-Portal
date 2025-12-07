package com.studentportal.services.impl;

import com.studentportal.commons.DtoMapper;
import com.studentportal.models.Grade;
import com.studentportal.models.Subject;
import com.studentportal.models.dto.GradeDto;
import com.studentportal.repos.GradeRepo;
import com.studentportal.services.GradeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepo gradeRepo;

    @Autowired
    public GradeServiceImpl(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }


    @Override
    public List<GradeDto> getByStudentId(Long studentId) {
        List<Grade> byStudentId = gradeRepo.findBySubject_StudentId(studentId);
        return DtoMapper.mapList(byStudentId, GradeDto.class);
    }

    @Override
    public List<GradeDto> fetchList() {
        List<Grade> list = gradeRepo.findAll();
        return DtoMapper.mapList(list, GradeDto.class);
    }

    @Override
    public GradeDto getById(Long id) {
        Grade grade = findById(id);
        return DtoMapper.map(grade, GradeDto.class);
    }

    @Override
    public GradeDto createGrade(GradeDto dto) {
        Subject subject = DtoMapper.map(dto.getSubjectName(), Subject.class);
        Grade grade = Grade.builder()
//                .student(dto.getStudent())
                .midterms(dto.getMidterms())
                .midterms(dto.getFinals())
                .subject(subject)
                .build();

        Grade save = gradeRepo.save(grade);
        return DtoMapper.map(save, GradeDto.class);
    }

    @Override
    public GradeDto updateGrade(GradeDto dto, Long id) {
        Grade grade = findById(id);
        Subject subject = DtoMapper.map(dto.getSubjectName(), Subject.class);
        grade.setSubject(subject);
//        grade.setStudent(dto.getStudent());
        grade.setMidterms(dto.getMidterms());
        grade.setFinals(dto.getFinals());

        Grade updated = gradeRepo.save(grade);

        return DtoMapper.map(updated, GradeDto.class);
    }

    @Override
    public void deleteGrade(Long id) {
        Grade byId = findById(id);
        gradeRepo.delete(byId);
    }

    @Override
    public Double calculateGpa(List<Grade> gradeList, Long studentId) {
        if (gradeList == null || gradeList.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (Grade g : gradeList) {
            Double amount = g.getAverage();

            double gpaValue;
            if (amount >= 90) gpaValue = 4.0;
            else if (amount >= 80) gpaValue = 3.0;
            else if (amount >= 70) gpaValue = 2.0;
            else if (amount >= 60) gpaValue = 1.0;
            else gpaValue = 0.0;

            total += gpaValue;
        }

        return total / gradeList.size();
    }

    private Grade findById(Long id) {
        return gradeRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Attendance not found with id: " + id)
        );
    }
}
