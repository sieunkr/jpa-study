package com.example.demo;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "matches")
@Getter
public class Matches {

    @Id
    @Column(name = "match_id")
    private Integer matchId;

    @ManyToOne
    @JoinColumn(name = "host_team")
    private Teams hostTeam;

    @ManyToOne
    @JoinColumn(name = "guest_team")
    private Teams guestTeam;

    @Column(name = "host_goals")
    private Integer hostGoals;

    @Column(name = "guest_goals")
    private Integer guestGoals;

}
