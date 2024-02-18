package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "tbllichhoc")
@Entity
public class Schedule {
    @Id
    private Integer id;
    private String name;
    @Transient
    private SectionClass sectionClass;
    @Transient
    private Teacher teacher;
    @Transient
    private Room room;
    @Transient
    private StudyWeek studyWeek;
    @Transient
    private StudyDate studyDate;
    @Transient
    private SchoolShift schoolShift;
    private String des;
}
