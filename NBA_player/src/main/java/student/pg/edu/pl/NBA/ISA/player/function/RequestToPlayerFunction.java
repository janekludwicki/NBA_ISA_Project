package student.pg.edu.pl.NBA.ISA.player.function;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.player.entity.Player;
import student.pg.edu.pl.NBA.ISA.player.dto.PutPlayerRequest;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.service.TeamService;

import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class RequestToPlayerFunction implements BiFunction<UUID, PutPlayerRequest, Player> {

    private TeamService teamService;

    @Autowired
    public RequestToPlayerFunction(TeamService teamService) {this.teamService = teamService;}
    @Override
    public Player apply(UUID id, PutPlayerRequest request) {
        Optional<Team> team = teamService.findById(request.getTeamID());
        return Player.builder()
                .id(id)
                .name(request.getName())
                .surname(request.getSurname())
                .yearOfBirth(request.getYearOfBirth())
                .jerseyNo(request.getJerseyNo())
                .height(request.getHeight())
                .position(request.getPosition())
                .team(team.orElse(null))
                .build();
    }
}
