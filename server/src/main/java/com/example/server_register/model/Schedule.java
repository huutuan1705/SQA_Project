package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Schedule {
    private Integer id;
    private String name;
    private SectionClass sectionClass;
    private Teacher teacher;
    private Room room;
    private StudyWeek studyWeek;
    private StudyDate studyDate;
    private SchoolShift schoolShift;
    private String des;
}
