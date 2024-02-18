package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "tblmonhockihoc")
@Entity
public class SubjectSemester {
    @Id
    private Integer id;
    @Transient
    private Subject subject;
    @Transient
    private Semester semester;
}
