package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.function;

import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto.GetTeamResponse;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.entity.Team;

import java.util.function.Function;

public class TeamToResponseFunction implements Function<Team, GetTeamResponse> {

    @Override
    public GetTeamResponse apply(Team team) {
        return GetTeamResponse.builder()
                .teamID(team.getTeamID())
                .name(team.getName())
                .city(team.getCity())
                .coach(team.getCoach())
                .noOfChampionships(team.getNoOfChampionships())
                .players(team.getPlayers().stream()
                        .map(player -> GetTeamResponse.Player.builder()
                                        .name(player.getName())
                                        .surname(player.getSurname())
                                        .yearOfBirth(player.getYearOfBirth())
                                        .jerseyNo(player.getJerseyNo())
                                        .Height(player.getHeight())
                                        .position(player.getPosition())
                                        .build())
                        .toList())
                .build();
    }

}
