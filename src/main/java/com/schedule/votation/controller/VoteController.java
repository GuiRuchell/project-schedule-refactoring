package com.schedule.votation.controller;

import com.schedule.votation.dto.vote.InVoteDto;
import com.schedule.votation.dto.vote.OutVoteDto;
import com.schedule.votation.dto.vote.OutVotingResultDto;
import com.schedule.votation.service.impl.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutVoteDto> findVoteById(@PathVariable Long id) {
        OutVoteDto outVoteDto = voteService.findVoteById(id);
        return new ResponseEntity<>(outVoteDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OutVoteDto> createUser(@RequestBody InVoteDto inVoteDto){
        OutVoteDto outVoteDto = voteService.createVote(inVoteDto);
        return new ResponseEntity<>(outVoteDto, HttpStatus.CREATED);
    }

    @GetMapping("/result/{id}")
    public ResponseEntity<OutVotingResultDto> findResultById(@PathVariable Long id) {
        OutVotingResultDto outVoteDto = voteService.votingResult(id);
        return new ResponseEntity<>(outVoteDto, HttpStatus.OK);
    }

}
