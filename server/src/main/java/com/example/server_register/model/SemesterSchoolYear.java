package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SemesterSchoolYear {
    private Integer id;
    private Semester semester;
    private SchoolYear schoolYear;
    private Boolean active;
    private Boolean register;
}
