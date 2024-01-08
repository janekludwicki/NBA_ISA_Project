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
public class GetTeamResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Player {
        private String name;

        private String surname;

        private Integer yearOfBirth;

        private Integer jerseyNo;

        private Integer Height;

        private String position;
    }
    private UUID teamID;
    private String name;
    private String city;
    private String coach;
    private Integer noOfChampionships;

    @Singular
    private List<Player> players;
}
