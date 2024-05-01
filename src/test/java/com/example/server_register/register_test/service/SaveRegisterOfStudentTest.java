package com.example.server_register.register_test.service;


import com.example.server_register.commons.exception.InvalidInputException;
import com.example.server_register.commons.suberror.ApiMessageError;
import com.example.server_register.dto.RegisterDto;
import com.example.server_register.model.*;
import com.example.server_register.repository.RegisterRepo;
import com.example.server_register.service.RegisterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan
class SaveRegisterOfStudentTest {

    @Autowired
    RegisterRepo registerRepo;
    @Autowired
    RegisterService registerService;

//    tat ca dang ki chuan se co tong so tin chi >13

    @Test
    @Rollback
    void saveRegistrationOfStudent_StandardTest1(){
//        dang ki nhieu LHP (15 tin chi), chua co dang ki cu

        try{
            List<RegisterDto> registers = new ArrayList<>();
            StudentDepartment studentDepartment = new StudentDepartment();
            SemesterSchoolYear semesterSchoolYear = new SemesterSchoolYear();
            SubjectSemester subjectSemester = new SubjectSemester();
            SectionClass sectionClass = new SectionClass();
            Register register = new Register();

            studentDepartment.setId(1);
            semesterSchoolYear.setId(8);

            RegisterDto registerDto = new RegisterDto(1,1);
            RegisterDto registerDto1 = new RegisterDto(1,10);
            RegisterDto registerDto2 = new RegisterDto(1,16);
            RegisterDto registerDto3 = new RegisterDto(1,22);
            RegisterDto registerDto4 = new RegisterDto(1,28);
            registers.add(registerDto);
            registers.add(registerDto1);
            registers.add(registerDto2);
            registers.add(registerDto3);
            registers.add(registerDto4);

            boolean ok = registerService.insertRegistration(registers);
            Assertions.assertTrue(ok);

            List<Register> registers1 = registerService.getRegisterOfStudent(studentDepartment.getId(), semesterSchoolYear.getId());
            Assertions.assertNotNull(registers1);
            Assertions.assertEquals(5, registers1.size());


        } catch (InvalidInputException | SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Test
    @Rollback
    void saveRegistrationOfStudent_StandardTest2(){
//        dang ki nhieu LHP (15 tin chi), da co 15 tin chi LHP cu
//        không có LHP trùng với LHP cũ nhưng 5 môn đều giống nhau, khác LHP mỗi môn
//        ket qua nhan duoc, xoa het dang ki cu va them 15 tin chi moi vao

        try{
            List<RegisterDto> registers = new ArrayList<>();
            StudentDepartment studentDepartment = new StudentDepartment();
            SemesterSchoolYear semesterSchoolYear = new SemesterSchoolYear();
            SubjectSemester subjectSemester = new SubjectSemester();
            SectionClass sectionClass = new SectionClass();
            Register register = new Register();

            studentDepartment.setId(2);
            semesterSchoolYear.setId(8);

            RegisterDto registerDto = new RegisterDto(2,2);
            RegisterDto registerDto1 = new RegisterDto(2,9);
            RegisterDto registerDto2 = new RegisterDto(2,15);
            RegisterDto registerDto3 = new RegisterDto(2,21);
            RegisterDto registerDto4 = new RegisterDto(2,27);
            registers.add(registerDto);
            registers.add(registerDto1);
            registers.add(registerDto2);
            registers.add(registerDto3);
            registers.add(registerDto4);

            boolean ok = registerService.insertRegistration(registers);
            Assertions.assertTrue(ok);

            List<Register> registers1 = registerService.getRegisterOfStudent(studentDepartment.getId(), semesterSchoolYear.getId());
            Assertions.assertNotNull(registers1);
            Assertions.assertEquals(5, registers1.size());


        } catch (InvalidInputException | SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Test
    @Rollback
    void saveRegistrationOfStudent_StandardTest3(){
//        dang ki nhieu LHP (15 tin chi), da co 15 tin chi LHP cu
//        không có LHP trùng với LHP cũ nhưng 5 môn đều giống nhau
//        trong đó có 1 môn giữ nguyên LHP, các môn còn lại khác LHP
//        ket qua nhan duoc, xoa het dang ki cu va them 15 tin chi moi vao

        try{
            List<RegisterDto> registers = new ArrayList<>();
            StudentDepartment studentDepartment = new StudentDepartment();
            SemesterSchoolYear semesterSchoolYear = new SemesterSchoolYear();
            SubjectSemester subjectSemester = new SubjectSemester();
            SectionClass sectionClass = new SectionClass();
            Register register = new Register();

            studentDepartment.setId(2);
            semesterSchoolYear.setId(8);

            RegisterDto registerDto = new RegisterDto(2,2);
            RegisterDto registerDto1 = new RegisterDto(2,10);
            RegisterDto registerDto2 = new RegisterDto(2,15);
            RegisterDto registerDto3 = new RegisterDto(2,21);
            RegisterDto registerDto4 = new RegisterDto(2,27);
            registers.add(registerDto);
            registers.add(registerDto1);
            registers.add(registerDto2);
            registers.add(registerDto3);
            registers.add(registerDto4);

            boolean ok = registerService.insertRegistration(registers);
            Assertions.assertTrue(ok);

            List<Register> registers1 = registerService.getRegisterOfStudent(studentDepartment.getId(), semesterSchoolYear.getId());
            Assertions.assertNotNull(registers1);
            Assertions.assertEquals(5, registers1.size());


        } catch (InvalidInputException | SQLException exception){
            throw new RuntimeException(exception);
        }
    }
//
//    @Test
//    void saveRegistrationOfStudent_StandardTest4(){
////        dang ki 1LHP, khac MH voi dang ki cu,
////        dang ki cu cung chi co 1 LHP ( xoa dang ki cu, them dang ki moi)
//    }
//
//    @Test
//    void saveRegistrationOfStudent_StandardTest5(){
////        dang ki nhieu LHP, dang ki cu it LHP hon
////        phu thuoc het vao dang ki moi, ke ca dang ki cu co nhieu
////        nhung dang ki moi co it thi van phai theo dang ki moi
//    }
//
//    @Test
//    void saveRegistrationOfStudent_StandardTest6(){
////        dang ki nhieu LHP, dang ki cu nhieu LHP hon
////        phu thuoc het vao dang ki moi, ke ca dang ki cu co nhieu
////        nhung dang ki moi co it thi van phai theo dang ki moi
//    }
//
//    @Test
//    void saveRegistrationOfStudent_ExceptionTest1(){
////        danh sach dang ki trung voi danh sach da dang ki
//    }
//
//    @Test
//    void saveRegistrationOfStudent_ExceptionTest2(){
////        danh sach dang ki null hoac rong
//    }

    @Test
    @Rollback
    void saveRegistrationOfStudent_ExceptionTest3(){
//        so tin chi >=19

        try{
            List<RegisterDto> registers = new ArrayList<>();
            StudentDepartment studentDepartment = new StudentDepartment();
            SemesterSchoolYear semesterSchoolYear = new SemesterSchoolYear();
            SubjectSemester subjectSemester = new SubjectSemester();
            SectionClass sectionClass = new SectionClass();
            Register register = new Register();

            RegisterDto registerDto = new RegisterDto(1,1);
            RegisterDto registerDto1 = new RegisterDto(1,5);
            RegisterDto registerDto2 = new RegisterDto(1,11);
            RegisterDto registerDto3 = new RegisterDto(1,17);
            RegisterDto registerDto4 = new RegisterDto(1,23);
            RegisterDto registerDto5 = new RegisterDto(1,29);
            RegisterDto registerDto6 = new RegisterDto(1,35);
            RegisterDto registerDto7 = new RegisterDto(1,41);
            registers.add(registerDto);
            registers.add(registerDto1);
            registers.add(registerDto2);
            registers.add(registerDto3);
            registers.add(registerDto4);
            registers.add(registerDto5);
            registers.add(registerDto6);
            registers.add(registerDto7);

            registerService.insertRegistration(registers);

        } catch (InvalidInputException exception){
            Assertions.assertEquals("Total credit must be less than 19"
                    , exception.getApiSubErrors().get(0).getErrorMessage());        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Rollback
    void saveRegistrationOfStudent_ExceptionTest4(){
//        so tin chi <= 13
        try{
            List<RegisterDto> registers = new ArrayList<>();
            StudentDepartment studentDepartment = new StudentDepartment();
            SemesterSchoolYear semesterSchoolYear = new SemesterSchoolYear();
            SubjectSemester subjectSemester = new SubjectSemester();
            SectionClass sectionClass = new SectionClass();
            Register register = new Register();

            RegisterDto registerDto = new RegisterDto(1,1);
            RegisterDto registerDto1 = new RegisterDto(1,5);
            RegisterDto registerDto2 = new RegisterDto(1,11);
            RegisterDto registerDto3 = new RegisterDto(1,17);
            registers.add(registerDto);
            registers.add(registerDto1);
            registers.add(registerDto2);
            registers.add(registerDto3);

            registerService.insertRegistration(registers);

        } catch (InvalidInputException exception){
            Assertions.assertEquals("Total credit must be greater than 13"
                    , exception.getApiSubErrors().get(0).getErrorMessage());        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
