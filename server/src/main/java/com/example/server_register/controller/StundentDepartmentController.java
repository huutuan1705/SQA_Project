package com.example.server_register.controller;

import com.example.server_register.model.StudentDepartment;
import com.example.server_register.repository.StudentDepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class StundentDepartmentController {

    private final StudentDepartmentRepo studentDepartmentRepo;

    @GetMapping()
    public List<StudentDepartment> getDepartmentOfStudent(@RequestParam("idStudent") Integer idStudent){
        return studentDepartmentRepo.getDepartmentOfStudent(idStudent);
    }
}
