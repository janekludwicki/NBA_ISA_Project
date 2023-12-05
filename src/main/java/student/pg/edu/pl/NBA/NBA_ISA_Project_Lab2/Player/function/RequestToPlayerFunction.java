package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.function;


import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.entity.Player;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.dto.PutPlayerRequest;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.entity.Team;

import java.util.UUID;
import java.util.function.Function;

@Component
public class RequestToPlayerFunction implements Function< PutPlayerRequest, Player> {

    @Override
    public Player apply(PutPlayerRequest request) {
        return Player.builder()
                .playerID(UUID.randomUUID())
                .name(request.getName())
                .surname(request.getSurname())
                .yearOfBirth(request.getYearOfBirth())
                .jerseyNo(request.getJerseyNo())
                .Height(request.getHeight())
                .position(request.getPosition())
                .team(Team.builder()
                        .teamID(request.getTeamID()).
                        build())
                .build();
    }
}
