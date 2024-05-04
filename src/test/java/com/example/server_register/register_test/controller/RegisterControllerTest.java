package com.example.server_register.register_test.controller;

import com.example.server_register.commons.RegisterRespone;
import com.example.server_register.controller.RegisterController;
import com.example.server_register.dto.RegisterDto;
import com.example.server_register.model.*;
import com.example.server_register.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan
class RegisterControllerTest {

    @Autowired
    RegisterController registerController;
    @Autowired
    RegisterService registerService;


    @Test
    @Rollback
    void testGetRegisterOfStudent() {

        int idStudentDepartment = 2;
        int idSemesterSchoolYear = 8;
        // Arrange

        List<RegisterDto> registers = new ArrayList<>();

        List<Register> registerList = new ArrayList<>();
        StudentDepartment studentDepartment = new StudentDepartment();
        SemesterSchoolYear semesterSchoolYear = new SemesterSchoolYear();
        SubjectSemester subjectSemester = new SubjectSemester();
        SectionClass sectionClass = new SectionClass();
        Register register = new Register();
        register.setSectionClass(sectionClass);
        register.setStudentDepartment(studentDepartment);
        registerList.add(register);

        studentDepartment.setId(idStudentDepartment);
        semesterSchoolYear.setId(idSemesterSchoolYear);

        RegisterDto registerDto = new RegisterDto(2,1);
        RegisterDto registerDto1 = new RegisterDto(2,10);
        RegisterDto registerDto2 = new RegisterDto(2,16);
        RegisterDto registerDto3 = new RegisterDto(2,22);
        RegisterDto registerDto4 = new RegisterDto(2,28);
        registers.add(registerDto);
        registers.add(registerDto1);
        registers.add(registerDto2);
        registers.add(registerDto3);
        registers.add(registerDto4);

        List<Register> expectedResult = registerService.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear);

        RegisterRespone<List<Register>> response = registerController.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear);

        assertNotNull(response);
        System.out.println(expectedResult.size());
    }
}
