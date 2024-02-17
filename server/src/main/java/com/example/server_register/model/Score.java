package com.example.server_register.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table
public class Score {
    private Integer id;
    private String name;
    private String des;
}
