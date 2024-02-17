package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Register {
    private Integer id;
    private StudentDepartment studentDepartment;
    private SectionClass sectionClass;
}
