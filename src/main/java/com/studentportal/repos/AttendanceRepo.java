package com.studentportal.repos;

import com.studentportal.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentId(Long studentId);

    List<Attendance> findByStudentIdAndDate(Long studentId, LocalDate date);

    List<Attendance> findByDate(LocalDate date);

    int countByStudentIdAndStatus(Long studentId, String status);
}
