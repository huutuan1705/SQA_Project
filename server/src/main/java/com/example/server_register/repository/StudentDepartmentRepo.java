package com.example.server_register.repository;

import com.example.server_register.model.Member;
import com.example.server_register.model.StudentDepartment;
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
public class StudentDepartmentRepo {

    private final EntityManager entityManager;

    public List<StudentDepartment> getDepartmentOfStudent(Integer idStudent){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("departmentOfStudent", "StudentDepartmentMapper")
                .registerStoredProcedureParameter("idSV", Integer.class, ParameterMode.IN)
                .setParameter("idSV", idStudent);
        List<?> resultList = query.getResultList();
        List<StudentDepartment> studentDepartments = new ArrayList<>();
        for(Object object : resultList){
            if(object instanceof StudentDepartment studentDepartment){
                studentDepartments.add(studentDepartment);
            }
        }
        return studentDepartments;
    }
}