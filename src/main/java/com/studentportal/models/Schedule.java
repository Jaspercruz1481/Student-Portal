package com.studentportal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SCHEDULE")
@Entity
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private Course course;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "INSTRUCTOR_ID", nullable = false)
    @Column(name = "INSTRUCTOR", nullable = false)
    private String instructor;

    @Column(name = "DAY_OF_WEEK", length = 15, nullable = false)
    private String dayOfWeek; // MONDAY, TUESDAY, etc.

    @Column(name = "START_TIME", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "END_TIME", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "ROOM", length = 50)
    private String room;

    @Column(name = "TERM", length = 20, nullable = false)
    private String term; // “1st Sem 2025”, “SY 2025-2026”

    @Column(name = "CLASS_SECTION", nullable = false)
    private String classSection;

}
