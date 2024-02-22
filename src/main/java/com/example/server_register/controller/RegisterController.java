package com.example.server_register.controller;

import com.example.server_register.model.Register;
import com.example.server_register.service.RegisterService;
import com.example.server_register.service.impl.RegisterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students/register")
@CrossOrigin
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping()
    public List<Register> getRegisterOfStudent(@RequestParam("idStudentDepartment")Integer idStudentDepartment,
                                               @RequestParam("idSemesterSchoolYear") Integer idSemesterSchoolYear){
        return registerService.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear);
    }

    @DeleteMapping()
    public void deleteOneRegistration(@RequestParam("idStudentDepartment")Integer idStudentDepartment,
                                         @RequestParam("idSectionClass") Integer idSectionClass){
        registerService.deleteOneRegistration(idStudentDepartment, idSectionClass);
    }

    @PostMapping()
    public void insertOneRegistration(@RequestParam("idStudentDepartment")Integer idStudentDepartment,
                                          @RequestParam("idSectionClass") Integer idSectionClass){
        registerService.insertOneRegistration(idStudentDepartment, idSectionClass);
    }
}
