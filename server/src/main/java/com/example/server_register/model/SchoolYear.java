package com.example.server_register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tblnamhoc")
@Entity
@NoArgsConstructor
public class SchoolYear {
    @Id
    private Integer id;
    private String name;
    private String des;

    public SchoolYear(Integer idSchoolYear, String schoolYearName) {
        this.id = idSchoolYear;
        this.name = schoolYearName;
    }
}
