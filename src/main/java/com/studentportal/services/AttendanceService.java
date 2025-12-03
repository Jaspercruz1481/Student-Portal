package com.studentportal.services;

import com.studentportal.models.dto.AttendanceDto;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

    List<AttendanceDto> getByStudentId(Long studentId);
    List<AttendanceDto> getByStudentIdAndDate(Long studentId, LocalDate date);
    List<AttendanceDto> getByDate(LocalDate date);
    List<AttendanceDto> fetchList();
    AttendanceDto getById(Long id);
    AttendanceDto createAttendance(AttendanceDto dto);
    AttendanceDto updateAttendance(AttendanceDto dto, Long id);
    void deleteAttendance(Long id);
}
