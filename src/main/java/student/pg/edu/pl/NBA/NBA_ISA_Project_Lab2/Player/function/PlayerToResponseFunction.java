package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.dto.GetPlayerResponse;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.entity.Player;

import javax.swing.text.html.parser.Entity;
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
                .Height(entity.getHeight())
                .position(entity.getPosition())
                .Team(GetPlayerResponse.Team.builder()
                    .id(entity.getTeam().getTeamID())
                    .name(entity.getTeam().getName())
                .build())
        .build();
    }
}
