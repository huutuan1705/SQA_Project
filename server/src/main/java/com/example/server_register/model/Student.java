package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tblsinhvien")
@Entity
@NoArgsConstructor
public class Student extends Member{
    private String studentId;

    public Student(String studentCode, Integer idStudent, String studentName) {
        super(idStudent, studentName);
        this.studentId= studentCode;
    }
}
