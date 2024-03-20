package com.example.server_register.service;

import com.example.server_register.model.Register;

import java.sql.SQLException;
import java.util.List;

public interface RegisterService {

    List<Register> getRegisterOfStudent(Integer idStudentDepartment, Integer idSemesterSchoolYear);

    void deleteOneRegistration(Integer idStudentDepartment, Integer idSectionClass);

    void insertOneRegistration(Integer idStudentDepartment, Integer idSectionClass) throws SQLException;
}
