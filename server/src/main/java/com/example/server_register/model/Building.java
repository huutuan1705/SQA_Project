package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tbltoanha")
public class Building {
    @Id
    private Integer id;
    private String name;
    private String des;
    @Transient
    private Room roomList;
}
