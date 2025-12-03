package com.studentportal.services.impl;

import com.studentportal.commons.DtoMapper;
import com.studentportal.models.Attendance;
import com.studentportal.models.dto.AttendanceDto;
import com.studentportal.repos.AttendanceRepo;
import com.studentportal.services.AttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private static final Logger LOG = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Override
    public List<AttendanceDto> getByStudentId(Long studentId) {
        List<Attendance> listByStudentId = attendanceRepo.findByStudentId(studentId);
        return DtoMapper.mapList(listByStudentId, AttendanceDto.class);
    }

    @Override
    public List<AttendanceDto> getByStudentIdAndDate(Long studentId, LocalDate date) {
        List<Attendance> byStudentIdAndDate = attendanceRepo.findByStudentIdAndDate(studentId, date);
        return DtoMapper.mapList(byStudentIdAndDate, AttendanceDto.class);
    }

    @Override
    public List<AttendanceDto> getByDate(LocalDate date) {
        List<Attendance> byDate = attendanceRepo.findByDate(date);
        return DtoMapper.mapList(byDate, AttendanceDto.class);
    }

    @Override
    public List<AttendanceDto> fetchList() {
        List<Attendance> list = attendanceRepo.findAll();
        return DtoMapper.mapList(list, AttendanceDto.class);
    }

    @Override
    public AttendanceDto getById(Long id) {
        Attendance attendance = findById(id);
        return DtoMapper.map(attendance, AttendanceDto.class);
    }

    @Override
    public AttendanceDto createAttendance(AttendanceDto dto) {
        Attendance attendance = Attendance.builder()
                .student(dto.getStudent())
                .date(dto.getDate())
                .status(dto.getStatus())
                .timeIn(dto.getTimeIn())
                .timeOut(dto.getTimeOut())
                .remarks(dto.getRemarks())
                .build();

        Attendance save = attendanceRepo.save(attendance);
        return DtoMapper.map(save, AttendanceDto.class);
    }

    @Override
    public AttendanceDto updateAttendance(AttendanceDto dto, Long id) {
        Attendance attendance = findById(id);

        attendance.setStatus(dto.getStatus());
        attendance.setDate(dto.getDate());
        attendance.setRemarks(dto.getRemarks());
        attendance.setStudent(dto.getStudent());
        attendance.setTimeIn(dto.getTimeIn());
        attendance.setTimeOut(dto.getTimeOut());

        Attendance updated = attendanceRepo.save(attendance);

        return DtoMapper.map(updated, AttendanceDto.class);
    }

    @Override
    public void deleteAttendance(Long id) {
        Attendance byId = findById(id);
        attendanceRepo.delete(byId);
    }

    private Attendance findById(Long id) {

        return attendanceRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Attendance not found with id: " + id)
        );
    }
}
