package com.example.server_register.service.impl;

import com.example.server_register.model.Schedule;
import com.example.server_register.repository.ScheduleRepo;
import com.example.server_register.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepo scheduleRepo;

    @Override
    public List<Schedule> getScheduleOfSectionClass(Integer idSectionClass) {
        return scheduleRepo.getSchedulesOfSectionClass(idSectionClass);
    }
}
