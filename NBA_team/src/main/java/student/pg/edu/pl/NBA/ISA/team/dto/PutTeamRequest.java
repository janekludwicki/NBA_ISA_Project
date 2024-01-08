package student.pg.edu.pl.NBA.ISA.team.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutTeamRequest {
    private String name;
    private String city;
    private String coach;
    private Integer noOfChampionships;
}
