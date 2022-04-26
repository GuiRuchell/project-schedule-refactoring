package com.schedule.votation.dto.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InScheduleDto {

    private String description;
    private Date deadline;

}
