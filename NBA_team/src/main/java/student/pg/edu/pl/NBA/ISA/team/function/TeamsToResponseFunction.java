package student.pg.edu.pl.NBA.ISA.team.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.team.dto.GetTeamsResponse;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.List;
import java.util.function.Function;

@Component
public class TeamsToResponseFunction implements Function<List<Team>, GetTeamsResponse> {

    @Override
    public GetTeamsResponse apply(List<Team> teams) {
        return GetTeamsResponse.builder()
                .teams(teams.stream()
                        .map(team -> GetTeamsResponse.Team.builder()
                                .id(team.getId())
                                .name(team.getName())
                                .city(team.getCity())
                                .coach(team.getCoach())
                                .noOfChampionships(team.getNoOfChampionships())
                                .build())
                        .toList())
                .build();
    }
}
