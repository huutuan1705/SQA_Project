package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDepartment {
    private Integer id;
    //nien khoa
    private String schoolYear;
    private Student student;
    private Department department;
    private Boolean active;
}
