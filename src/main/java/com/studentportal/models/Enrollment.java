package com.studentportal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Table(name = "ENROLLMENT")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private Course course;

    @Column(name = "TERM", nullable = false, length = 20)
    private String term;

    @Column(name = "ENROLLMENT_DATE", nullable = false)
    private LocalDate enrollmentDate;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status; // e.g. ENROLLED, DROPPED, COMPLETED

    @Column(name = "REMARKS", length = 500)
    private String remarks;

}
