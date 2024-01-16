package student.pg.edu.pl.NBA.ISA.player.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.player.dto.PatchPlayerRequest;
import student.pg.edu.pl.NBA.ISA.player.entity.Player;

import java.util.function.BiFunction;

@Component
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
