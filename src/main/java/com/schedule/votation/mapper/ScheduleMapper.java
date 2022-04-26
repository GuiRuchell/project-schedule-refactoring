package com.schedule.votation.mapper;

import com.schedule.votation.dto.schedule.InScheduleDto;
import com.schedule.votation.dto.schedule.OutScheduleDto;
import com.schedule.votation.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ScheduleMapper {

    public static final ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    public abstract Schedule inScheduleDtoToSchedule(InScheduleDto inScheduleDto);

    public abstract OutScheduleDto OutScheduleDtoToSchedule(Schedule schedule);

}
