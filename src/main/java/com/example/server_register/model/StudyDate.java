package com.example.server_register.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class StudyDate {
    @Id
    private Integer id;
    private String name;
    private String des;

    public StudyDate(Integer idDate, String dateName) {
        this.id = idDate;
        this.name = dateName;
    }
}
