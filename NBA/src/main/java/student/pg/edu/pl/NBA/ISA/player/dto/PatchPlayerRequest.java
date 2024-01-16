package student.pg.edu.pl.NBA.ISA.player.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PatchPlayerRequest {
    private String name;

    private String surname;

    private Integer yearOfBirth;

    private Integer jerseyNo;

    private Integer Height;

    private String position;
}
