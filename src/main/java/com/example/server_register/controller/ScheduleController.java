package com.example.server_register.controller;

import com.example.server_register.model.Schedule;
import com.example.server_register.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/section-classes")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedule")
    public List<Schedule> getScheduleOfSectionClass(@RequestParam("idSectionClass") Integer idSectionClass){
        return scheduleService.getScheduleOfSectionClass(idSectionClass);
    }

}
