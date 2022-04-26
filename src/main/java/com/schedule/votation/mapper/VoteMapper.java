package com.schedule.votation.mapper;

import com.schedule.votation.dto.vote.InVoteDto;
import com.schedule.votation.dto.vote.OutVoteDto;
import com.schedule.votation.dto.vote.OutVotingResultDto;
import com.schedule.votation.entity.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class VoteMapper {

    public static final VoteMapper INSTANCE = Mappers.getMapper(VoteMapper.class);

    public abstract Vote inVoteDtoToVote(InVoteDto inVoteDto);

    public abstract OutVoteDto outVoteDtoToVote(Vote vote);

//    public abstract OutVotingResultDto outVotingResultDtoToResult(Vote vote);
}
