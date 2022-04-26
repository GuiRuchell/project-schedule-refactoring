package com.schedule.votation.mapper;

import com.schedule.votation.dto.schedule.InScheduleDto;
import com.schedule.votation.dto.schedule.OutScheduleDto;
import com.schedule.votation.entity.Schedule;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-26T10:31:11-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.2.jar, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class ScheduleMapperImpl extends ScheduleMapper {

    @Override
    public Schedule inScheduleDtoToSchedule(InScheduleDto inScheduleDto) {
        if ( inScheduleDto == null ) {
            return null;
        }

        Schedule schedule = new Schedule();

        schedule.setDescription( inScheduleDto.getDescription() );
        schedule.setDeadline( inScheduleDto.getDeadline() );

        return schedule;
    }

    @Override
    public OutScheduleDto OutScheduleDtoToSchedule(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        OutScheduleDto outScheduleDto = new OutScheduleDto();

        outScheduleDto.setId( schedule.getId() );
        outScheduleDto.setDescription( schedule.getDescription() );
        outScheduleDto.setDeadline( schedule.getDeadline() );

        return outScheduleDto;
    }
}
