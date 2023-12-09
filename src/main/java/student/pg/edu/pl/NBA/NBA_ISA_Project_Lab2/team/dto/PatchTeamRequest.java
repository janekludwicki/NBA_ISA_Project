package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchTeamRequest {
    private String name;
    private String city;
    private String coach;
    private Integer noOfChampionships;
}
