package com.example.server_register.controller;

import com.example.server_register.commons.RegisterRespone;
import com.example.server_register.model.StudentDepartment;
import com.example.server_register.repository.StudentDepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@CrossOrigin
public class StundentDepartmentController {

    private final StudentDepartmentRepo studentDepartmentRepo;

    @GetMapping()
    public RegisterRespone<List<StudentDepartment>> getDepartmentOfStudent(@RequestParam("idStudent") Integer idStudent){
        return RegisterRespone.build(studentDepartmentRepo.getDepartmentOfStudent(idStudent));
    }
}
