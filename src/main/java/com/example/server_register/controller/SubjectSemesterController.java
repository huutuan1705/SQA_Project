package com.example.server_register.controller;

import com.example.server_register.model.SubjectSemester;
import com.example.server_register.service.SubjectSemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects/")
@RequiredArgsConstructor
@CrossOrigin
public class SubjectSemesterController {

    private final SubjectSemesterService subjectSemesterService;

    @GetMapping("/register")
    public List<SubjectSemester> getRegisteredSubject(@RequestParam("idStudent") Integer idStudent,
                                                      @RequestParam("idSemester") Integer idSemester){
        return subjectSemesterService.getSubjectOfStudent(idStudent, idSemester);
    }
}
