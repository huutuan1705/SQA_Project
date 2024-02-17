package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Table(name = "truong")
@Entity
public class School {
    @Id
    private Integer id;
    private String name;
    private String address;
    private String des;
    @Transient
    private List<Building> buildingList;
    @Transient
    private List<Department> departmentList;
}
