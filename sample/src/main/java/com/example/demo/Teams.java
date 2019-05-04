package com.example.demo;

import lombok.Getter;
import org.springframework.data.annotation.Persistent;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "teams")
@Getter
public class Teams {

    @Id
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "team_name")
    private String teamName;

    @OneToMany(mappedBy = "hostTeam")
    private Collection<Matches> homeMatches;

    @OneToMany(mappedBy = "guestTeam")
    private Collection<Matches> guestMatches;

    @Transient
    private Integer numPoints;

    public Integer getNumPoints(){

        int tempNumPoints = 0;
        for(Matches match : homeMatches){
            if(match.getHostGoals() > match.getGuestGoals()){
                tempNumPoints = tempNumPoints + 3;
            }
            else if(match.getHostGoals() == match.getGuestGoals()){
                tempNumPoints = tempNumPoints + 1;
            }
            else{
            }
        }

        for(Matches match : guestMatches){
            if(match.getHostGoals() < match.getGuestGoals()){
                tempNumPoints = tempNumPoints + 3;
            }
            else if(match.getHostGoals() == match.getGuestGoals()){
                tempNumPoints = tempNumPoints + 1;
            }
            else{
            }
        }

        return tempNumPoints;
    }

}
