package com.example.server_register.controller;

import com.example.server_register.commons.RegisterRespone;
import com.example.server_register.commons.exception.ErrorMessage;
import com.example.server_register.commons.exception.ErrorMessageConstant;
import com.example.server_register.dto.RegisterDto;
import com.example.server_register.model.Register;
import com.example.server_register.service.RegisterService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students/register")
@CrossOrigin
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping()
    public RegisterRespone<List<Register>> getRegisterOfStudent(@RequestParam("idStudentDepartment")Integer idStudentDepartment,
                                                               @RequestParam("idSemesterSchoolYear") Integer idSemesterSchoolYear){
        List<Register> result = registerService.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear);
        return RegisterRespone.build(result);
    }

    @PostMapping()
    public RegisterRespone<?> insertRegistrationList(@RequestBody List<RegisterDto> registerDtos) throws SQLException {
        registerService.insertRegistration(registerDtos);
        return RegisterRespone.build(ErrorMessageConstant.SUCCESS);
    }

//    @PostMapping()
//    public RegisterRespone<?> insertOneRegistration(@RequestParam("idStudentDepartment") Integer idStudentDepartment,
//                                                    @RequestParam("idSectionClass") Integer idSectionClass) throws SQLException {
//        registerService.insertTest(idStudentDepartment, idSectionClass);
//        return RegisterRespone.build(ErrorMessageConstant.SUCCESS);
//    }

//    @PostMapping("/test")
//    public RegisterRespone<?> insert(@RequestBody List<RegisterDto> registerDtos) throws SQLException {
//        registerService.insertRegistration(registerDtos);
//        return RegisterRespone.build(ErrorMessageConstant.SUCCESS);
//    }

//    @DeleteMapping()
//    public RegisterRespone<?> deleteRegistration(@RequestParam("idStudentDepartment") Integer idStudentDepartment,
//                                                 @RequestParam("idSectionClass") Integer idSectionClass){
//        registerService.deleteRegistration(idStudentDepartment, idSectionClass);
//        return RegisterRespone.build(ErrorMessageConstant.SUCCESS);
//    }
}
