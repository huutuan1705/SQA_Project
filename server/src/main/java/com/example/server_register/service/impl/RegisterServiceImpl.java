package com.example.server_register.service.impl;

import com.example.server_register.model.Register;
import com.example.server_register.repository.RegisterRepo;
import com.example.server_register.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepo registerRepo;

    @Override
    public List<Register> getRegisterOfStudent(Integer idStudentDepartment, Integer idSemesterSchoolYear) {
        return registerRepo.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear);
    }

    @Override
    public boolean deleteOneRegistration(Integer idStudentDepartment, Integer idSectionClass) {
        return registerRepo.deleteOneRegistration(idStudentDepartment, idSectionClass);
    }

    @Override
    public boolean insertOneRegistration(Integer idStudentDepartment, Integer idSectionClass) {
        return registerRepo.insertOneRegistration(idStudentDepartment, idSectionClass);
    }
}
