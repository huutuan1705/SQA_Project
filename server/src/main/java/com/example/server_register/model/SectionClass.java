package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SectionClass {
    private Integer id;
    private String name;
    private Integer maxAmountOfStudent;
    private Integer realAmountOfStudent;
    private String des;
    private SubjectSemester subjectSemester;
    private List<Schedule> scheduleList;
}
