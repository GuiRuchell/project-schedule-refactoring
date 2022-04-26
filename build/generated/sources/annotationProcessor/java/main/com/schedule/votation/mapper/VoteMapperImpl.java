package com.schedule.votation.mapper;

import com.schedule.votation.dto.vote.InVoteDto;
import com.schedule.votation.dto.vote.OutVoteDto;
import com.schedule.votation.entity.Vote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-26T10:31:11-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.2.jar, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class VoteMapperImpl extends VoteMapper {

    @Override
    public Vote inVoteDtoToVote(InVoteDto inVoteDto) {
        if ( inVoteDto == null ) {
            return null;
        }

        Vote vote = new Vote();

        vote.setIdSchedule( inVoteDto.getIdSchedule() );
        vote.setIdUser( inVoteDto.getIdUser() );
        vote.setVote( inVoteDto.getVote() );

        return vote;
    }

    @Override
    public OutVoteDto outVoteDtoToVote(Vote vote) {
        if ( vote == null ) {
            return null;
        }

        OutVoteDto outVoteDto = new OutVoteDto();

        outVoteDto.setId( vote.getId() );
        outVoteDto.setIdSchedule( vote.getIdSchedule() );
        outVoteDto.setIdUser( vote.getIdUser() );
        outVoteDto.setVote( vote.getVote() );

        return outVoteDto;
    }
}
