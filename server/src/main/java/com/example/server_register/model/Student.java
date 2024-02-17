package com.example.server_register.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
public class Student extends Member{
    private String studentId;
}
