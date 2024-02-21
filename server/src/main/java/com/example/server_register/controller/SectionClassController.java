package com.example.server_register.controller;

import com.example.server_register.model.SectionClass;
import com.example.server_register.service.SectionClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/section-classes")
@RestController
@RequiredArgsConstructor
public class SectionClassController {

    private final SectionClassService sectionClassService;

    @GetMapping()
    public List<SectionClass> getSectionClass(@RequestParam("idStudentDepartment") Integer idStudentDepartment,
                                              @RequestParam("idSubjectSemester")Integer idSubjectSemester){
        return sectionClassService.getSectionClassForStudentRegister(idStudentDepartment, idSubjectSemester);
    }
}
