package com.schedule.votation.controller;

import com.schedule.votation.dto.schedule.InScheduleDto;
import com.schedule.votation.dto.schedule.OutScheduleDto;
import com.schedule.votation.entity.Schedule;
import com.schedule.votation.service.impl.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutScheduleDto> findScheduleById(@PathVariable Long id) {
        OutScheduleDto outSchedulesDto = scheduleService.findScheduleById(id);
        return new ResponseEntity<>(outSchedulesDto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<OutScheduleDto> createSchedule(@RequestBody InScheduleDto inScheduleDto){
        OutScheduleDto outSchedulesDto = scheduleService.createSchedule(inScheduleDto);
        return new ResponseEntity<>(outSchedulesDto, HttpStatus.CREATED);
    }

    @PostMapping("/session")
    public ResponseEntity<Schedule> insertSession(@RequestBody Schedule schedule){
        Schedule outSchedulesDto = scheduleService.insertSession(schedule);
        return new ResponseEntity<>(outSchedulesDto, HttpStatus.CREATED);
    }
}
