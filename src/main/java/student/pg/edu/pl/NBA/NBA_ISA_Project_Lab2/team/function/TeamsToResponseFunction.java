package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto.GetTeamsResponse;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.entity.Team;

import java.util.List;
import java.util.function.Function;

@Component
public class TeamsToResponseFunction implements Function<List<Team>, GetTeamsResponse> {

    @Override
    public GetTeamsResponse apply(List<Team> teams) {
        return GetTeamsResponse.builder()
                .teams(teams.stream()
                        .map(team -> GetTeamsResponse.Team.builder()
                                .teamID(team.getTeamID())
                                .name(team.getName())
                                .city(team.getCity())
                                .coach(team.getCoach())
                                .noOfChampionships(team.getNoOfChampionships())
                                .PlayersNo(team.getPlayers().size())
                                .build())
                        .toList())
                .build();
    }
}