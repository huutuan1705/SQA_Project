package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "monhoc")
@Entity
public class Subject {
    @Id
    private Integer id;
    private String name;
    //so tin chi
    private Integer credit;
    private String des;
    @Transient
    private List<SubjectScore> scoreList;
    //mon tien quyet
    @Transient
    private List<Subject> prerequisiteSubject;
}
