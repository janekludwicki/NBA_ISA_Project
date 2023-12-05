package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.function;

import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto.PatchTeamRequest;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.entity.Team;

import java.util.function.BiFunction;

public class UpdateTeamWithRequestFunction implements BiFunction<Team, PatchTeamRequest, Team> {

    @Override
    public Team apply(Team entity, PatchTeamRequest request) {
        return Team.builder()
                .teamID(entity.getTeamID())
                .name(request.getName())
                .city(request.getCity())
                .coach(request.getCoach())
                .noOfChampionships(request.getNoOfChampionships())
                .build();
    }
}
