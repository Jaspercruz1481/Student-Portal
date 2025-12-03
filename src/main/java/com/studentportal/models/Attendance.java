package com.studentportal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Table(name = "ATTENDANCE")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private Student student;

    @Column(name = "DATE", nullable = false)
    private LocalDate date;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    @Column(name = "TIME_IN")
    private LocalDateTime timeIn;

    @Column(name = "TIME_OUT")
    private LocalDateTime timeOut;

    @Column(name = "REMARKS", length = 500)
    private String remarks;

}
