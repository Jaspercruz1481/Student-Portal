package com.studentportal.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "SUBJECT")
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private Student student;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    private Grade grade;

    @Column(name = "SUBJECT_NAME", nullable = false)
    private String name;
}
