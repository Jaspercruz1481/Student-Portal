package com.studentportal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "SUBJECT")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @JsonBackReference
    private Student student;

    @Column(name = "SUBJECT_NAME", nullable = false)
    private String name;

    @Column(name = "UNITS", nullable = false)
    private int units;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
}
