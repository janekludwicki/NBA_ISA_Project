package student.pg.edu.pl.NBA.ISA.player.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetPlayerResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Team {

        private UUID id;
    }

    private UUID id;

    private String name;

    private String surname;

    private Integer yearOfBirth;

    private Integer jerseyNo;

    private Integer height;

    private String position;

    private Team Team;

}
