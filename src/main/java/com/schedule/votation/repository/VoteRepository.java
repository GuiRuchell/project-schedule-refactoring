package com.schedule.votation.repository;

import com.schedule.votation.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Vote findByIdUserAndIdSchedule(Long idUser, Long idSchedule);

    List<Vote> findByIdSchedule(Long idSchedule);

}
