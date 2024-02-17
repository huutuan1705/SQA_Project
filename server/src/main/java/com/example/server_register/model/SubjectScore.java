package com.example.server_register.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "monhocdaudiem")
@Entity
public class SubjectScore {
    @Id
    private Integer id;
    @Transient
    private Score score;
    @Column(name = "tile")
    private Float ratio;
}
