package student.pg.edu.pl.NBA.ISA.team.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetTeamResponse {

    private UUID id;

    private String name;

    private String city;

    private String coach;

    private Integer noOfChampionships;
}
