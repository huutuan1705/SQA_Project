package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "tblsinhvienkhoa")
@Entity
public class StudentDepartment {
    @Id
    private Integer id;
    //nien khoa
    private String schoolYear;
    @Transient
    private Student student;
    @Transient
    private Department department;
    private Boolean active;
}
