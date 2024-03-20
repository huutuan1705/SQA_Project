package com.example.server_register.repository;

import com.example.server_register.model.Register;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegisterRepo  {

    private final EntityManager entityManager;

    public List<Register> getRegisterOfStudent(Integer idStudentDepartment, Integer idSemesterSchoolYear){

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getRegisterOfStudent", "RegisterMapper")
                .registerStoredProcedureParameter("idSVK", Integer.class, ParameterMode.IN)
                .setParameter("idSVK", idStudentDepartment)
                .registerStoredProcedureParameter("idKihoc", Integer.class, ParameterMode.IN)
                .setParameter("idKihoc", idSemesterSchoolYear);
        return getRegistersFromQuery(query);
    }

    private static List<Register> getRegistersFromQuery(StoredProcedureQuery query) {

        List<?> objects = query.getResultList();
        List<Register> registers = new ArrayList<>();
        for(Object object : objects){
            if(object instanceof Register register){
                registers.add(register);
            }
        }
        return registers;
    }

    public void insertOneRegistration(Integer idStudentDepartment, Integer idSectionClass) throws SQLException {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("InsertRegistration")
                .registerStoredProcedureParameter("idSVK", Integer.class, ParameterMode.IN)
                .setParameter("idSVK", idStudentDepartment)
                .registerStoredProcedureParameter("idLHP", Integer.class, ParameterMode.IN)
                .setParameter("idLHP", idSectionClass);

        query.execute();
    }

    public boolean deleteOneRegistration(Integer idStudentDepartment, Integer idSectionClass) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("DeleteOneRegistration")
                .registerStoredProcedureParameter("idSVK", Integer.class, ParameterMode.IN)
                .setParameter("idSVK", idStudentDepartment)
                .registerStoredProcedureParameter("idLHP", Integer.class, ParameterMode.IN)
                .setParameter("idLHP", idSectionClass);
        return query.execute();
    }
}
