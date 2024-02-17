package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SubjectSemester {
    private Integer id;
    private Subject subject;
    private Semester semester;
}
