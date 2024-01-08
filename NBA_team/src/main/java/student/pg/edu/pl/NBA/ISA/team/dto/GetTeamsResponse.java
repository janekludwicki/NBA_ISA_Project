package student.pg.edu.pl.NBA.ISA.team.dto;

import lombok.*;

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
    }

    @Singular
    private List<Team> teams;
}