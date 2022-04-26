package com.schedule.votation.service.impl;

import com.schedule.votation.dto.vote.InVoteDto;
import com.schedule.votation.dto.vote.OutVoteDto;
import com.schedule.votation.dto.vote.OutVotingResultDto;
import com.schedule.votation.entity.Schedule;
import com.schedule.votation.entity.Vote;
import com.schedule.votation.mapper.VoteMapper;
import com.schedule.votation.repository.ScheduleRepository;
import com.schedule.votation.repository.VoteRepository;
import com.schedule.votation.service.VoteInterface;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService implements VoteInterface {

    private final VoteRepository voteRepository;
    private final ScheduleRepository scheduleRepository;
    private final VoteMapper voteMapper;

    public VoteService(VoteRepository voteRepository, ScheduleRepository scheduleRepository, VoteMapper voteMapper) {
        this.voteRepository = voteRepository;
        this.scheduleRepository = scheduleRepository;
        this.voteMapper = voteMapper;
    }

    @Override
    public OutVoteDto findVoteById(Long id) {
        Vote vote = voteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vote ID does not exist"));

        return voteMapper.outVoteDtoToVote(vote);
    }

    @Override
    public OutVoteDto createVote(InVoteDto inVoteDto) {
        Vote vote = voteMapper.inVoteDtoToVote(inVoteDto);
        return voteMapper.outVoteDtoToVote(voteRepository.save(vote));
    }

    @Override
    public OutVotingResultDto votingResult(Long idSchedule) {
        Date date = new Date();
        Optional<Schedule> schedule = scheduleRepository.findById(idSchedule);
        List<Vote> vote = voteRepository.findByIdSchedule(idSchedule);

        if (date.before(schedule.get().getDeadline())) {
            throw new RuntimeException("Voting in progress!");
        }

        int yes = 0;
        int no = 0;
        String result = "Result";

        for (int i = 0; i < vote.size(); i++) {

            if (vote.get(i).getVote()) {
                yes++;
            } else {
                no++;
            }
        }
        if (yes > no) {
            result = "Schedule Disapproved";
        } else {
            result = "Schedule Approved";
        }

        OutVotingResultDto outVotingResultDto = new OutVotingResultDto(idSchedule, yes, no, result);
        return outVotingResultDto;
    }

}
