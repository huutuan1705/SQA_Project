package com.example.server_register.service.impl;

import com.example.server_register.commons.exception.ErrorMessageConstant;
import com.example.server_register.commons.exception.InvalidInputException;
import com.example.server_register.commons.suberror.ApiMessageError;
import com.example.server_register.dto.RegisterDto;
import com.example.server_register.model.Register;
import com.example.server_register.model.SectionClass;
import com.example.server_register.model.SemesterSchoolYear;
import com.example.server_register.repository.RegisterRepo;
import com.example.server_register.repository.SectionClassRepo;
import com.example.server_register.repository.SemesterSchoolYearRepo;
import com.example.server_register.service.RegisterService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepo registerRepo;
    private final SectionClassRepo sectionClassRepo;
    private final SemesterSchoolYearRepo semesterSchoolYearRepo;

    @Override
    public void insertTest(Integer idStudentDepartment, Integer idSectionClass) throws SQLException {
        registerRepo.insertOneRegistration(new RegisterDto(idStudentDepartment, idSectionClass));
    }

    @Override
    public List<Register> getRegisterOfStudent(Integer idStudentDepartment, Integer idSemesterSchoolYear) {
        return registerRepo.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear);
    }

    @Override
    public void insertRegistration(List<RegisterDto> newRegisterList) throws SQLException {

        List<SemesterSchoolYear> getSemes = semesterSchoolYearRepo.getSemesterRegister();
        List<Register> registeredList = registerRepo.getRegisterOfStudent(newRegisterList.get(0).getIdStudentDepartment(), getSemes.get(0).getId());
        validateCredit(newRegisterList);
        handleAddNewRegistration(newRegisterList, registeredList);
        handleDeleteRegistration(newRegisterList, registeredList);
    }

    private void handleAddNewRegistration(List<RegisterDto> newRegisterList, List<Register> registeredList) {
        registeredList.forEach(register -> {
            int registeredId = register.getSectionClass().getId();
            if (newRegisterList.stream().noneMatch(dto -> dto.getIdSectionClass() == registeredId)) {
                try {
                    // ngược
                    registerRepo.insertOneRegistration(getDto(newRegisterList, registeredId));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    private void handleDeleteRegistration(List<RegisterDto> newRegisterList, List<Register> registeredList) {
        newRegisterList.forEach(dto -> {
            int newRegisterId = dto.getIdSectionClass();
            if (registeredList.stream().noneMatch(register -> register.getSectionClass().getId() == newRegisterId)) {
                registerRepo.deleteOneRegistration(getDto(newRegisterList, newRegisterId));
            }
        });
    }

    private RegisterDto getDto(List<RegisterDto> newRegisterList, int registeredId) {
        return newRegisterList.stream()
                .filter(dto -> dto.getIdSectionClass() == registeredId)
                .findFirst()
                .orElse(null);
    }

    private void validateCredit(List<RegisterDto> registerDtos) {
        int totalCredit = getTotalCredit(registerDtos);
        if (totalCredit > 19) {
            throw new InvalidInputException(ErrorMessageConstant.BAD_REQUEST,
                    Collections.singletonList(new ApiMessageError("Total credit must be less than 19")));
        }
        if (totalCredit < 14) {
            throw new InvalidInputException(ErrorMessageConstant.BAD_REQUEST,
                    Collections.singletonList(new ApiMessageError("Total credit must be greater than 13")));
        }
    }

    private int getTotalCredit(List<RegisterDto> registerDtos) {
        int totalCredit = 0;
        for (RegisterDto registerDto : registerDtos) {
            totalCredit += sectionClassRepo.getOneSectionClass(registerDto.getIdSectionClass())
                                            .getSubjectSemester()
                                            .getSubject()
                                            .getCredit();
        }
        return totalCredit;
    }
}
