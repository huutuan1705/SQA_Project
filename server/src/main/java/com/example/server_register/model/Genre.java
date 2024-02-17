package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
// bo mon
public class Genre {
    private Integer id;
    private String name;
    private String des;
    private Department department;
    private List<Subject> subjectList;
    private List<Teacher> teacherList;
}
