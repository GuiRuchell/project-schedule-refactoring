package com.schedule.votation.service;

import com.schedule.votation.dto.vote.InVoteDto;
import com.schedule.votation.dto.vote.OutVoteDto;
import com.schedule.votation.dto.vote.OutVotingResultDto;

public interface VoteInterface {

    OutVoteDto findVoteById(Long id);
    OutVoteDto createVote(InVoteDto inVoteDto);
    OutVotingResultDto votingResult(Long idSchedule);
}
