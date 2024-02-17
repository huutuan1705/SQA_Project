package com.example.server_register.service.impl;

import com.example.server_register.model.SectionClass;
import com.example.server_register.repository.SectionClassRepo;
import com.example.server_register.service.SectionClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionClassServiceImpl implements SectionClassService {

    private final SectionClassRepo sectionClassRepo;

    @Override
    public List<SectionClass> getSectionClassForStudentRegister(Integer idStudent, Integer idSubjectSemester) {
        return sectionClassRepo.getSectionClassForStudent(idStudent, idSubjectSemester);
    }

    @Override
    public List<SectionClass> getSectionClassForTeacher(Integer idTeacher, Integer idSubjectSemester) {
        return sectionClassRepo.getSectionClassForTeacher(idTeacher, idSubjectSemester);
    }
}
