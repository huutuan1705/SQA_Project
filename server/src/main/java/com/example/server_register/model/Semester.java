package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "hocki")
@Entity
public class Semester {
    @Id
    private Integer id;
    private String name;
    private String des;
}
