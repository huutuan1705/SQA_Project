package com.example.server_register.repository;

import com.example.server_register.model.SemesterSchoolYear;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SemesterSchoolYearRepo {

    private final EntityManager entityManager;

    public List<SemesterSchoolYear> getSemesterRegister(){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("activeRegisterSemester", "SemesterSchoolYearMapper");
        List<?> activeRegisterSemesters = query.getResultList();
        List<SemesterSchoolYear> semesterSchoolYears = new ArrayList<>();
        for (Object object : activeRegisterSemesters){
            if(object instanceof SemesterSchoolYear semesterSchoolYear){
                semesterSchoolYears.add(semesterSchoolYear);
            }
        }
        return semesterSchoolYears;
    }
}
