package com.example.server_register.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@NoArgsConstructor
@SqlResultSetMapping(
        name = "SemesterSchoolYearMapper",
        classes = @ConstructorResult(
                targetClass = SemesterSchoolYear.class,
                columns = {
                        @ColumnResult(name = "idnamhoc", type = Integer.class),
                        @ColumnResult(name = "namhoc", type = String.class),
                        @ColumnResult(name = "idhocki", type = Integer.class),
                        @ColumnResult(name = "hocki", type = String.class),
                        @ColumnResult(name = "idkihoc", type = Integer.class),
                }
        )
)
public class SemesterSchoolYear {
    @Id
    private Integer id;
    @Transient
    private Semester semester;
    @Transient
    private SchoolYear schoolYear;
    private Boolean active;
    private Boolean register;

    public SemesterSchoolYear(Integer idSchoolYear, String schoolYearName, Integer idSemester, String semesterName, Integer idSemesterSchoolYear){
        this.id = idSemesterSchoolYear;
        this.semester = new Semester(idSemester, semesterName);
        this.schoolYear = new SchoolYear(idSchoolYear, schoolYearName);
    }

    public SemesterSchoolYear(Integer idSemesterSchoolYear) {
        this.id = idSemesterSchoolYear;
    }
}
