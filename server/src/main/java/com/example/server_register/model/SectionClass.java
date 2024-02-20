package com.example.server_register.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class SectionClass {
    @Id
    private Integer id;
    private String name;
    private Integer maxAmountOfStudent;
    private Integer realAmountOfStudent;
    private String des;
    @Transient
    private SubjectSemester subjectSemester;
    @Transient
    private List<Schedule> scheduleList;


}
