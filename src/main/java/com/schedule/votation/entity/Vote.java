package com.schedule.votation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VOTE")
    private Long id;

    @Column(name = "ID_SCHEDULE")
    private Long idSchedule;

    @Column(name = "ID_USER")
    private Long idUser;

    @Column(name = "VOTE")
    private Boolean vote;

}
