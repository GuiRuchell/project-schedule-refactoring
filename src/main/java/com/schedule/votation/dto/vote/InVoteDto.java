package com.schedule.votation.dto.vote;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InVoteDto {

    private Long idSchedule;
    private Long idUser;
    private Boolean vote;

}
