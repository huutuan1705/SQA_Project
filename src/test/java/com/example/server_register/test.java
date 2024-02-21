package com.example.server_register;

import com.example.server_register.model.*;
import com.example.server_register.repository.MemberRepo;
import com.example.server_register.repository.SemesterSchoolYearRepo;
import com.example.server_register.service.SemesterSchoolYearService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Query;
import jakarta.persistence.StoredProcedureQuery;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.test.annotation.Rollback;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class test {

    @Autowired
    EntityManager entityManager;



    @Test
    public void getAccount() throws ParseException {

//        entityManager.createNamedStoredProcedureQuery("firstProcedure")
//                .setParameter("usr", "b20dccn352")
//                .setParameter("pwd", "123456");
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("checkAccount", "MemberMapper")
                .registerStoredProcedureParameter("usr", String.class, ParameterMode.IN)
                .setParameter("usr", "b20dccn352")
                .registerStoredProcedureParameter("pwd", String.class, ParameterMode.IN)
                .setParameter("pwd", "123456");
        Member member = (Member)query.getSingleResult();
        System.out.println( member.getRole());
    }

    @Test
    public void getDepartmentStudent(){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("departmentOfStudent", "StudentDepartmentMapper")
                .registerStoredProcedureParameter("idSV", Integer.class, ParameterMode.IN)
                .setParameter("idSV", 1);
        List<?> resultList = query.getResultList();
        List<StudentDepartment> studentDepartments = new ArrayList<>();
        for(Object object : resultList){
//            System.out.println(object[0]);
            if(object instanceof StudentDepartment){
                studentDepartments.add((StudentDepartment) object);
            }
        }
        System.out.println(studentDepartments.get(0).getDepartment().getName());
    }

    @Test
    public void getActiveRegisterSemester(){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("activeRegisterSemester", "SemesterSchoolYearMapper");
        List<?> activeRegisterSemesters = query.getResultList();
        List<SemesterSchoolYear> semesterSchoolYears = new ArrayList<>();
        for (Object object : activeRegisterSemesters){
            if(object instanceof SemesterSchoolYear){
                semesterSchoolYears.add((SemesterSchoolYear) object);
            }
        }
        System.out.println(semesterSchoolYears.size());
    }

    @Test
    public void getSubjectOfStudent(){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getRegisteredSubject" , "SubjectSemesterMapper")
                .registerStoredProcedureParameter("idSVK", Integer.class, ParameterMode.IN)
                .setParameter("idSVK", 1)
                .registerStoredProcedureParameter("idKihoc", Integer.class, ParameterMode.IN)
                .setParameter("idKihoc", 7);
        List<?> resultSets = query.getResultList();
        List<SubjectSemester> subjectSemesters = new ArrayList<>();
        for(Object object : resultSets){
            if(object instanceof SubjectSemester){
                subjectSemesters.add((SubjectSemester) object);
            }
        }
        System.out.println(subjectSemesters.size());
    }

    @Test
    public void getScheduleOfSectionclass(){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SheduleOfSectionClass", "ScheduleMapper")
                .registerStoredProcedureParameter("idLHP", Integer.class, ParameterMode.IN)
                .setParameter("idLHP", 6);

        List<?> objects = query.getResultList();
        List<Schedule> schedules = new ArrayList<>();
        for (Object object : objects) {
            if (object instanceof Schedule schedule) {
                schedules.add((Schedule) object);
            }
        }
        System.out.println(schedules.size());
    }
}
