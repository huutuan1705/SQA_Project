package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "phonghoc")
@Entity
public class Room {
    @Id
    private Integer id;
    private String name;
    private Integer capacity;
    private String des;
    @Transient
    private Building building;
}
