//package com.example.server_register;
//
//
//import com.example.server_register.model.*;
//import com.example.server_register.repository.RegisterRepo;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
//@ComponentScan
//public class SaveRegisterOfStudentTest {
//
//    @Autowired private final RegisterRepo registerRepo;
//
//    @Test
//    void saveRegistrationOfStudent_StandardTest1(){
//        //dang ki 1LHP, chua co dang ki cu
////        44
////        ArrayList<Dangkihoc> listDK = new ArrayList<Dangkihoc>();
////        //tao dang ki hoc thu nhat
////        SinhvienKhoa svk = new SinhvienKhoa();
////        svk.setId(3);
////        Kihoc kh = new Kihoc();
////        kh.setId(4);
////        MonhocKihoc mhkh = new MonhocKihoc();
////        mhkh.setId(1);
////        mhkh.setKihoc(kh);
////        Lophocphan lhp = new Lophocphan();
////        lhp.setId(3);
////        lhp.setMonhocKihoc(mhkh);
////        Dangkihoc dk = new Dangkihoc();
////        dk.setSinhvienKhoa(svk);
////        dk.setLophocphan(lhp);
////        listDK.add(dk);
//
//        List<Register> registerList = new ArrayList<>();
//        StudentDepartment studentDepartment = new StudentDepartment();
//        SubjectSemester subjectSemester = new SubjectSemester();
//        SemesterSchoolYear semesterSchoolYear = new SemesterSchoolYear();
//        SectionClass sectionClass = new SectionClass();
//        Register register = new Register();
//
//
//        studentDepartment.setId(4);
//
//        semesterSchoolYear.setId(8);
//
//        subjectSemester.setId(1);
//        subjectSemester.setSemesterSchoolYear(semesterSchoolYear);
//
//        sectionClass.setId(4);
//        sectionClass.setSubjectSemester(subjectSemester);
//
//        register.setStudentDepartment(studentDepartment);
//        register.setSectionClass(sectionClass);
//
//        registerList.add(register);
//
//
//    }
//}
