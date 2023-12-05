package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutPlayerRequest {

    private String name;

    private String surname;

    private Integer yearOfBirth;

    private Integer jerseyNo;

    private Integer Height;

    private String position;

    private UUID teamID;
}
