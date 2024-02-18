package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tblsinhvien")
@Entity
public class Student extends Member{
    private String studentId;
}
