package com.example.server_register.service;

import com.example.server_register.dto.RegisterDto;
import com.example.server_register.model.Register;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

public interface RegisterService {

    List<Register> getRegisterOfStudent(Integer idStudentDepartment, Integer idSemesterSchoolYear);

    void insertRegistration(List<RegisterDto> registerDtos) throws SQLException;

    void insertTest(Integer idStudentDepartment, Integer idSectionClass) throws SQLException;

    void deleteRegistration(Integer idStudentDepartment, Integer idSectionClass);
}
