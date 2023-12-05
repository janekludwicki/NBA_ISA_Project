package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.entity.Player;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetTeamsResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class Team {
        private UUID teamID;
        private String name;
        private String city;
        private String coach;
        private Integer noOfChampionships;
        private Integer PlayersNo;
    }

    @Singular
    private List<Team> teams;
}
