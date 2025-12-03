package com.studentportal.services.impl;

import com.studentportal.commons.DtoMapper;
import com.studentportal.models.Grade;
import com.studentportal.models.Schedule;
import com.studentportal.models.dto.GradeDto;
import com.studentportal.models.dto.ScheduleDto;
import com.studentportal.repos.ScheduleRepo;
import com.studentportal.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepo scheduleRepo;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    @Override
    public List<ScheduleDto> getByStudentId(Long studentId) {
        List<Schedule> byStudentId = scheduleRepo.findByStudentId(studentId);
        return DtoMapper.mapList(byStudentId, ScheduleDto.class);
    }

    @Override
    public List<ScheduleDto> fetchList() {
        List<Schedule> list = scheduleRepo.findAll();
        return DtoMapper.mapList(list, ScheduleDto.class);
    }

    @Override
    public ScheduleDto getById(Long id) {
        Schedule schedule = findById(id);
        return DtoMapper.map(schedule, ScheduleDto.class);
    }

    @Override
    public ScheduleDto createSchedule(ScheduleDto dto) {
        Schedule schedule = Schedule.builder()
                .student(dto.getStudent())
                .course(dto.getCourse())
                .instructor(dto.getInstructor())
                .dayOfWeek(dto.getDayOfWeek())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .room(dto.getRoom())
                .term(dto.getTerm())
                .classSection(dto.getClassSection())
                .build();

        Schedule save = scheduleRepo.save(schedule);
        return DtoMapper.map(save, ScheduleDto.class);
    }

    @Override
    public ScheduleDto updateSchedule(ScheduleDto dto, Long id) {
        Schedule schedule = findById(id);

        schedule.setCourse(dto.getCourse());
        schedule.setStudent(dto.getStudent());
        schedule.setRoom(dto.getRoom());
        schedule.setInstructor(dto.getInstructor());
        schedule.setTerm(dto.getTerm());
        schedule.setDayOfWeek(dto.getDayOfWeek());
        schedule.setEndTime(dto.getEndTime());
        schedule.setStartTime(dto.getStartTime());

        Schedule updated = scheduleRepo.save(schedule);

        return DtoMapper.map(updated, ScheduleDto.class);
    }

    @Override
    public void deleteSchedule(Long id) {
        Schedule byId = findById(id);
        scheduleRepo.delete(byId);
    }

    private Schedule findById(Long id) {
        return scheduleRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Attendance not found with id: " + id)
        );
    }
}
