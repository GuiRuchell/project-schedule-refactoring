package com.schedule.votation.service.impl;

import com.schedule.votation.dto.schedule.InScheduleDto;
import com.schedule.votation.dto.schedule.OutScheduleDto;
import com.schedule.votation.entity.Schedule;
import com.schedule.votation.mapper.ScheduleMapper;
import com.schedule.votation.repository.ScheduleRepository;
import com.schedule.votation.service.ScheduleInterface;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class ScheduleService implements ScheduleInterface {

    private final ScheduleMapper scheduleMapper;
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleMapper scheduleMapper, ScheduleRepository scheduleRepository) {
        this.scheduleMapper = scheduleMapper;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public OutScheduleDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule ID does not exist"));

        return scheduleMapper.OutScheduleDtoToSchedule(schedule);
    }

    @Override
    public OutScheduleDto createSchedule(InScheduleDto inScheduleDto) {
        Schedule schedule = scheduleMapper.inScheduleDtoToSchedule(inScheduleDto);
        return scheduleMapper.OutScheduleDtoToSchedule(scheduleRepository.save(schedule));
    }

    @Override
    public Schedule insertSession(Schedule schedule) {
        Optional<Schedule> scheduleDB = scheduleRepository.findById(schedule.getId());
        Date date = new Date();
        if (scheduleDB.isPresent()) {
            if (scheduleDB.get().getDeadline() == null) {
                if (schedule.getDeadline() != null) {
                    scheduleDB.get().setDeadline(schedule.getDeadline());
                    return scheduleRepository.saveAndFlush(scheduleDB.get());
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.MINUTE, 1);
                    calendar.getTime();
                    scheduleDB.get().setDeadline(calendar.getTime());

                    return scheduleRepository.saveAndFlush(scheduleDB.get());
                }
            }
            throw new RuntimeException("The schedule is closed!");
        }
        throw new RuntimeException("The schedule does not exist in the database!");
    }
}

