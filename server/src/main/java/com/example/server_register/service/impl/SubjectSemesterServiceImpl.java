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
    public List<SubjectSemester> getSubjectOfStudent(Integer idStudent, Integer idSemester) {
        return subjectSemesterRepo.getSubjectOfStudent(idStudent, idSemester);
    }

    @Override
    public List<SubjectSemester> getSubjectOfTeacher(Integer idTeacher, Integer idSemester) {
        return subjectSemesterRepo.getSubjectOfTeacher(idTeacher, idSemester);
    }


}
