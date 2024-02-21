package com.example.server_register.repository;

import com.example.server_register.model.SectionClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SectionClassRepo {

    private final EntityManager entityManager;

    public List<SectionClass> getSectionClass(Integer idStudentDepartment, Integer idSubjectSemester){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getSectionClass", "SectionClassMapper")
                .registerStoredProcedureParameter("idSVK", Integer.class, ParameterMode.IN)
                .setParameter("idSVK", idStudentDepartment)
                .registerStoredProcedureParameter("idMHKH", Integer.class, ParameterMode.IN)
                .setParameter("idMHKH", idSubjectSemester);
        List<?> objects = query.getResultList();
        List<SectionClass> sectionClasses = new ArrayList<>();
        for(Object object : objects){
            if(object instanceof SectionClass sectionClass){
                sectionClasses.add(sectionClass);
            }
        }
        return sectionClasses;
    }
}
