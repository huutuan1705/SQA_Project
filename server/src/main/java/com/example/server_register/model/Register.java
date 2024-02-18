package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "tbldangkihoc")
@Entity
public class Register {
    @Id
    private Integer id;
    @Transient
    private StudentDepartment studentDepartment;
    @Transient
    private SectionClass sectionClass;
}
