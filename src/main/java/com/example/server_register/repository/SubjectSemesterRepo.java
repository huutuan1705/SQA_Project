package com.example.server_register.repository;

import com.example.server_register.model.SectionClass;
import com.example.server_register.model.Semester;
import com.example.server_register.model.SemesterSchoolYear;
import com.example.server_register.model.SubjectSemester;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectSemesterRepo {

    private final EntityManager entityManager;

    public List<SubjectSemester> getSubjectSemesterForStudent(Integer idStudentDepartment,
                                                        Integer idSemesterSchoolYear){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getRegisteredSubject" , "SubjectSemesterMapper")
                .registerStoredProcedureParameter("idSVK", Integer.class, ParameterMode.IN)
                .setParameter("idSVK", idStudentDepartment)
                .registerStoredProcedureParameter("idKihoc", Integer.class, ParameterMode.IN)
                .setParameter("idKihoc", idSemesterSchoolYear);
        return getSubjectSemestersFromQuery(idSemesterSchoolYear, query);
    }

    private static List<SubjectSemester> getSubjectSemestersFromQuery(Integer idSemesterSchoolYear, StoredProcedureQuery query) {
        List<?> resultSets = query.getResultList();
        List<SubjectSemester> subjectSemesters = new ArrayList<>();
        for(Object object : resultSets){
            if(object instanceof SubjectSemester subjectSemester){
                subjectSemester.setSemesterSchoolYear(new SemesterSchoolYear(idSemesterSchoolYear));
                subjectSemesters.add(subjectSemester);
            }
        }
        return subjectSemesters;
    }
}
