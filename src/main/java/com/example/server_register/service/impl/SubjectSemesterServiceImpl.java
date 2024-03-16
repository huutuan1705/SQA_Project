package com.example.server_register.service.impl;

import com.example.server_register.model.SubjectSemester;
import com.example.server_register.repository.SubjectSemesterRepo;
import com.example.server_register.service.SubjectSemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectSemesterServiceImpl implements SubjectSemesterService {

    private final SubjectSemesterRepo subjectSemesterRepo;

    @Override
    public List<SubjectSemester> getSubjectOfStudent(Integer idStudentDepartment, Integer idSemesterSchoolYear) {
        return subjectSemesterRepo.getSubjectSemesterForStudent(idStudentDepartment, idSemesterSchoolYear);
    }
}
