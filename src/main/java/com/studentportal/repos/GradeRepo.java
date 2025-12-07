package com.studentportal.repos;

import com.studentportal.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Long>  {

    List<Grade> findBySubject_StudentId(Long studentId);
}
