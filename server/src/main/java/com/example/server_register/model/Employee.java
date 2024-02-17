package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "nhanvien")
public class Employee extends Member{
    private String role;
}
