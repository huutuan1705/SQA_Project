package com.example.server_register.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table
public class Room {
    private Integer id;
    private String name;
    private Integer capacity;
    private String des;
    private Building building;
}
