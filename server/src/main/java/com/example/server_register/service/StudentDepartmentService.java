package com.example.server_register.service;

import com.example.server_register.model.StudentDepartment;

import java.util.List;

public interface StudentDepartmentService {

    List<StudentDepartment> getStudentOfDepartment(int idStudent);
}
