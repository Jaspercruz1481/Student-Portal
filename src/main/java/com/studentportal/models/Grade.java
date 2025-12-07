package com.studentportal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "GRADE")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "STUDENT_ID", nullable = false)
//    private Student student;

    @Column(name = "MIDTERMS", nullable = false)
    private Double midterms;

    @Column(name = "FINALS", nullable = false)
    private Double finals;

    @Column(name = "AVERAGE", nullable = false)
    private Double average;

    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Subject subject;

}
