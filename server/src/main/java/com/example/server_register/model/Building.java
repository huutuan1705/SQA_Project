package com.example.server_register.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Building {
    private Integer id;
    private String name;
    private String des;
    private Room roomList;
}
