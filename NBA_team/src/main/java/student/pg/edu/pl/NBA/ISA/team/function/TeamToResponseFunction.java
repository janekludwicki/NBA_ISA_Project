package student.pg.edu.pl.NBA.ISA.team.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.team.dto.GetTeamResponse;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.function.Function;

@Component
public class TeamToResponseFunction implements Function<Team, GetTeamResponse> {

    @Override
    public GetTeamResponse apply(Team team) {
        return GetTeamResponse.builder()
                .id(team.getTeamID())
                .name(team.getName())
                .city(team.getCity())
                .coach(team.getCoach())
                .noOfChampionships(team.getNoOfChampionships())
                .build();
    }

}
