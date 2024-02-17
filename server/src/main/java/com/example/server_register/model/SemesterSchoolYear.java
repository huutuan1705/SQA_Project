package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "kihoc")
@Entity
public class SemesterSchoolYear {
    @Id
    private Integer id;
    @Transient
    private Semester semester;
    @Transient
    private SchoolYear schoolYear;
    private Boolean active;
    private Boolean register;
}
