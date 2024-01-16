package student.pg.edu.pl.NBA.ISA.player.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetPlayersByTeam {
    @Singular
    private List<GetPlayersResponse.Player> players;
}
