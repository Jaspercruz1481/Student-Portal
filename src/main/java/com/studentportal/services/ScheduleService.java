package com.studentportal.services;

import com.studentportal.models.dto.ScheduleDto;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<ScheduleDto> getByStudentId(Long studentId);
    List<ScheduleDto> fetchList();
    ScheduleDto getById(Long id);
    ScheduleDto createSchedule(ScheduleDto dto);
    ScheduleDto updateSchedule(ScheduleDto dto, Long id);
    void deleteSchedule(Long id);
}
