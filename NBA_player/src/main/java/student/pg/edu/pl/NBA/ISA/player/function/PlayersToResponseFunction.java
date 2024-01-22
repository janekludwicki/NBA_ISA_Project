package student.pg.edu.pl.NBA.ISA.player.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.player.dto.GetPlayersResponse;
import student.pg.edu.pl.NBA.ISA.player.entity.Player;

import java.util.List;
import java.util.function.Function;

@Component
public class PlayersToResponseFunction implements Function<List<Player>, GetPlayersResponse>{

    @Override
    public GetPlayersResponse apply(List<Player> entities) {
        return GetPlayersResponse.builder()
                .players(entities.stream()
                        .map(player -> GetPlayersResponse.Player.builder()
                                .id(player.getId())
                                .name(player.getName())
                                .surname(player.getSurname())
                                .build())
                        .toList())
                .build();
    }
}
