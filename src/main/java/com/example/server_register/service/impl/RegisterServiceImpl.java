package com.example.server_register.service.impl;

import com.example.server_register.commons.exception.ErrorMessageConstant;
import com.example.server_register.commons.exception.InvalidInputException;
import com.example.server_register.commons.suberror.ApiMessageError;
import com.example.server_register.dto.RegisterDto;
import com.example.server_register.model.Register;
import com.example.server_register.model.SemesterSchoolYear;
import com.example.server_register.repository.RegisterRepo;
import com.example.server_register.repository.SectionClassRepo;
import com.example.server_register.repository.SemesterSchoolYearRepo;
import com.example.server_register.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepo registerRepo;
    private final SectionClassRepo sectionClassRepo;
    private final SemesterSchoolYearRepo semesterSchoolYearRepo;


    @Override
    public List<Register> getRegisterOfStudent(Integer idStudentDepartment, Integer idSemesterSchoolYear) {
        return registerRepo.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear);
    }

    @Override
    public boolean insertRegistration(List<RegisterDto> newRegisterList) throws SQLException {

        List<SemesterSchoolYear> getSemes = semesterSchoolYearRepo.getSemesterRegister();
        List<Register> registeredList = registerRepo.getRegisterOfStudent(newRegisterList.get(0).getIdStudentDepartment(), getSemes.get(0).getId());
        validateCredit(newRegisterList);
        handleDeleteRegistration(newRegisterList, registeredList);
        handleAddNewRegistration(newRegisterList, registeredList);
        return true;
    }

    private void handleDeleteRegistration(List<RegisterDto> newRegisterList, List<Register> registeredList) {
        int id = newRegisterList.get(0).getIdStudentDepartment();
        for (Register register : registeredList){
            int check = 0;
            for (RegisterDto registerDto : newRegisterList){
                if (registerDto.getIdSectionClass().equals(register.getSectionClass().getId())) {
                    check = 1;
                    break;
                }
            }
            if (check == 0){
                registerRepo.deleteOneRegistration(new RegisterDto(id,register.getSectionClass().getId()));
            }
        }
    }


    private void handleAddNewRegistration(List<RegisterDto> newRegisterList, List<Register> registeredList) throws SQLException {
        for(RegisterDto registerDto : newRegisterList){
            int check = 0;
            for (Register register : registeredList){
                if(register.getSectionClass().getId().equals(registerDto.getIdSectionClass())){
                    check = 1;
                    break;
                }
            }
            if(check == 0){
                registerRepo.insertOneRegistration(registerDto);
            }
        }
    }


    private void validateCredit(List<RegisterDto> registerDtos) {
        int totalCredit = getTotalCredit(registerDtos);
        if (totalCredit >= 19) {
            throw new InvalidInputException(ErrorMessageConstant.BAD_REQUEST,
                    new ApiMessageError("Total credit must be less than 19"));
        }
        if (totalCredit <= 13) {
            throw new InvalidInputException(ErrorMessageConstant.BAD_REQUEST,
                    new ApiMessageError("Total credit must be greater than 13"));
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
