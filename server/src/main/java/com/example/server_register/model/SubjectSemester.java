package com.example.server_register.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@SqlResultSetMapping(
        name = "SubjectSemesterMapper",
        classes = @ConstructorResult(
                targetClass = SubjectSemester.class,
                columns = {
                        @ColumnResult(name = "idmhkh", type = Integer.class),
                        @ColumnResult(name = "idmh", type = Integer.class),
                        @ColumnResult(name = "tenmh", type = String.class),
                        @ColumnResult(name = "so_tin_chi", type = Integer.class),
                }
        )
)
public class SubjectSemester {
    @Id
    private Integer id;
    @Transient
    private Subject subject;
    @Transient
    private SemesterSchoolYear semesterSchoolYear;

    public SubjectSemester(Integer idSubjectSemester, Integer idSubject, String subjectName, Integer credit){
        this.id = idSubjectSemester;
        this.subject = new Subject(idSubject, subjectName, credit);
    }
}
