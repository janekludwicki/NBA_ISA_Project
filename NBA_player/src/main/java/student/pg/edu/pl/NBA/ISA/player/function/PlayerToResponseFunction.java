package student.pg.edu.pl.NBA.ISA.player.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.player.dto.GetPlayerResponse;
import student.pg.edu.pl.NBA.ISA.player.entity.Player;

import java.util.function.Function;

@Component
public class PlayerToResponseFunction implements Function<Player, GetPlayerResponse> {

    @Override
    public GetPlayerResponse apply(Player entity) {
        return GetPlayerResponse.builder()
                .id(entity.getPlayerID())
                .name(entity.getName())
                .surname(entity.getSurname())
                .yearOfBirth(entity.getYearOfBirth())
                .jerseyNo(entity.getJerseyNo())
                .height(entity.getHeight())
                .position(entity.getPosition())
                .Team(GetPlayerResponse.Team.builder()
                        .id(entity.getTeam().getTeamID())
                .build())
        .build();
    }
}
