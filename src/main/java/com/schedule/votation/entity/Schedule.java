package com.schedule.votation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCHEDULE")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DEADLINE")
    private Date deadline;

}
