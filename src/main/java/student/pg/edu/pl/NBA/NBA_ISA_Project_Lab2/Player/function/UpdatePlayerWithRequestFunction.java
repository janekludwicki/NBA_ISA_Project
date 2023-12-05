package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.function;

import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.dto.PatchPlayerRequest;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.entity.Player;

import java.util.function.BiFunction;

public class UpdatePlayerWithRequestFunction implements BiFunction<Player, PatchPlayerRequest, Player> {

    @Override
    public Player apply(Player entity, PatchPlayerRequest request) {
        return Player.builder()
                .playerID(entity.getPlayerID())
                .name(request.getName())
                .surname(request.getSurname())
                .yearOfBirth(request.getYearOfBirth())
                .jerseyNo(request.getJerseyNo())
                .Height(request.getHeight())
                .position(request.getPosition())
                .team(entity.getTeam())
                .build();
    }
}
