package com.studentportal.repos;

import com.studentportal.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
    List<Schedule> findByStudentId(Long studentId);
}
