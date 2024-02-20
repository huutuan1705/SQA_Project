package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Table(name = "tblkhoa")
@Entity
@NoArgsConstructor
public class Department {
    @Id
    private Integer id;
    private String name;
    private String des;
    @Transient
    private Subject subjectList;

    public Department(Integer idDepartment, String departmentName) {
        this.id = idDepartment;
        this.name = departmentName;
    }
}
