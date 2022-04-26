package com.schedule.votation.service;

import com.schedule.votation.dto.schedule.InScheduleDto;
import com.schedule.votation.dto.schedule.OutScheduleDto;
import com.schedule.votation.dto.vote.OutVotingResultDto;
import com.schedule.votation.entity.Schedule;

public interface ScheduleInterface {

    OutScheduleDto findScheduleById(Long id);
    OutScheduleDto createSchedule(InScheduleDto inScheduleDto);
    Schedule insertSession(Schedule schedule);
}
