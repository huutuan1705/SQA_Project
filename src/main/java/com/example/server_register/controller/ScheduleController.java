package com.example.server_register.controller;

import com.example.server_register.model.Schedule;
import com.example.server_register.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/section-classes")
@RequiredArgsConstructor
@CrossOrigin
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedule")
    public List<Schedule> getScheduleOfSectionClass(@RequestParam("idSectionClass") Integer idSectionClass){
        return scheduleService.getScheduleOfSectionClass(idSectionClass);
    }

}
