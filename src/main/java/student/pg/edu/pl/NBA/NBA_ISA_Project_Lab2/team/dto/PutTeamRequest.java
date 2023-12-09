package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto;

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
