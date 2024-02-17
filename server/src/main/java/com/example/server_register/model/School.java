package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class School {
    private Integer id;
    private String name;
    private String address;
    private String des;
    private List<Building> buildingList;
    private List<Department> departmentList;
}
