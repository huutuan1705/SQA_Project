package com.example.server_register.register_test.service;

import com.example.server_register.model.Register;
import com.example.server_register.repository.RegisterRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan
class GetRegisteredOfStudentTest {

    @Autowired
    RegisterRepo registerRepo;

//    @Test
//    void getRegisteredOfStudent_StandardTest1(){
////        sinh vien chi co 1 dang ki
//        int idStudentDepartment = 3;
//        int idSemesterSchoolYear = 8;
//        List<Register> registers = registerRepo.getRegisterOfStudent(idStudentDepartment,idSemesterSchoolYear);
//        Assertions.assertNotNull(registers);
//        Assertions.assertEquals(1, registers.size());
//        Assertions.assertEquals(idStudentDepartment, registers.get(0).getStudentDepartment().getId());
//        Assertions.assertEquals(idSemesterSchoolYear, registers.get(0).getSectionClass()
//                                                                .getSubjectSemester()
//                                                                .getSemesterSchoolYear()
//                                                                .getId());
//    }
//
//    @Test
//    void getRegisteredOfStudent_StandardTest2(){
////        sinh vien co nhieu hon 1 dang ki
//        int idStudentDepartment = 2;
//        int idSemesterSchoolYear = 8;
//        List<Register> registers = registerRepo.getRegisterOfStudent(idStudentDepartment,idSemesterSchoolYear);
//        Assertions.assertNotNull(registers);
//        Assertions.assertEquals(2, registers.size());
//        registers.forEach(register -> {
//            Assertions.assertEquals(idStudentDepartment, register.getStudentDepartment().getId());
//            Assertions.assertEquals(idSemesterSchoolYear, register.getSectionClass()
//                                                                    .getSubjectSemester()
//                                                                    .getSemesterSchoolYear()
//                                                                    .getId());
//        });
//    }

    @Test
    void getRegisteredOfStudent_ExceptionTest1(){
//        ki hoc ton tai, sinh vien khong ton tai
        int idStudentDepartment = 101011;
        int idSemesterSchoolYear = 8;
        List<Register> registers = registerRepo.getRegisterOfStudent(idStudentDepartment,idSemesterSchoolYear);
        Assertions.assertNotNull(registers);
    }

    @Test
    void getRegisteredOfStudent_ExceptionTest2(){
//        ki hoc khong ton tai, sinh vien ton tai
        int idStudentDepartment = 5;
        int idSemesterSchoolYear = 1212;
        List<Register> registers = registerRepo.getRegisterOfStudent(idStudentDepartment,idSemesterSchoolYear);
        Assertions.assertNotNull(registers);
    }

    @Test
    void getRegisteredOfStudent_ExceptionTest3(){
//        ki hoc khong ton tai, sinh vien khong ton tai
        int idStudentDepartment = 131231;
        int idSemesterSchoolYear = 1212;
        List<Register> registers = registerRepo.getRegisterOfStudent(idStudentDepartment,idSemesterSchoolYear);
        Assertions.assertNotNull(registers);
    }

    @Test
    void getRegisteredOfStudent_ExceptionTest4(){
//        sinh vien ton tai, dang ki ki khac chu khong phai ki hien tai
        int idStudentDepartment = 5;
        int idSemesterSchoolYear = 7;
        List<Register> registers = registerRepo.getRegisterOfStudent(idStudentDepartment,idSemesterSchoolYear);
        Assertions.assertNotNull(registers);
    }
}
