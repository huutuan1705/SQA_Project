package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Table(name = "tblhocki")
@Entity
@NoArgsConstructor
public class Semester {
    @Id
    private Integer id;
    private String name;
    private String des;

    public Semester(Integer idSemester, String semesterName) {
        this.id = idSemester;
        this.name = semesterName;
    }
}
