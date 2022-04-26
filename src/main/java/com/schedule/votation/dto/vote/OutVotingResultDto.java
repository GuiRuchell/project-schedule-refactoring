package com.schedule.votation.dto.vote;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OutVotingResultDto {

    private Long idSchedule;
    private int yes;
    private int no;
    private String result;

}
