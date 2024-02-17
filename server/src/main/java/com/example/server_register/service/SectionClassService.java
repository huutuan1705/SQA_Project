package com.example.server_register.service;

import com.example.server_register.model.SectionClass;

import java.util.List;

public interface SectionClassService {

    List<SectionClass> getSectionClassForStudentRegister(Integer idStudent,
                                                         Integer idSubjectSemester);

    List<SectionClass> getSectionClassForTeacher(Integer idTeacher,
                                                 Integer idSubjectSemester);
}
