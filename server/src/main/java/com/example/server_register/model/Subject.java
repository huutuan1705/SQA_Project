package com.example.server_register.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table
public class Subject {
    private Integer id;
    private String name;
    //so tin chi
    private Integer credit;
    private String des;
    private List<SubjectScore> scoreList;
    //mon tien quyet
    private List<Subject> prerequisiteSubject;
}
