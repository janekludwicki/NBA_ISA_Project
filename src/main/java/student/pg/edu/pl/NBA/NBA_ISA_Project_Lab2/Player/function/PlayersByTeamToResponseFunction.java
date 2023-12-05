package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.function;

import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.dto.GetPlayersByTeam;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.dto.GetPlayersResponse;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.entity.Player;

import java.util.List;
import java.util.function.Function;

public class PlayersByTeamToResponseFunction implements Function<List<Player>, GetPlayersByTeam> {

    @Override
    public GetPlayersByTeam apply(List<Player> entities) {
        return GetPlayersByTeam.builder()
                .players(entities.stream()
                        .map(player -> GetPlayersResponse.Player.builder()
                                .id(player.getPlayerID())
                                .name(player.getName())
                                .build())
                        .toList())
                .build();
    }
}
