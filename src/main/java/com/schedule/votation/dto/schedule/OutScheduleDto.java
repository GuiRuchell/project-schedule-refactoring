package com.schedule.votation.dto.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OutScheduleDto {

    private Long id;
    private String description;
    private Date deadline;

}
