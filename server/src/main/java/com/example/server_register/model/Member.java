package com.example.server_register.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "")
public class Member {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private Date dob;
    private String address;
    private String phoneNumber;
    private String email;
    private String des;
}
