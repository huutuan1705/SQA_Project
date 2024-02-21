package com.example.server_register.service.impl;

import com.example.server_register.model.StudentDepartment;
import com.example.server_register.repository.StudentDepartmentRepo;
import com.example.server_register.service.StudentDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentDepartmentServiceImpl implements StudentDepartmentService {

    private final StudentDepartmentRepo studentDepartmentRepo;

    @Override
    public List<StudentDepartment> getStudentOfDepartment(int idStudent) {
        return studentDepartmentRepo.getDepartmentOfStudent(idStudent);
    }
}
