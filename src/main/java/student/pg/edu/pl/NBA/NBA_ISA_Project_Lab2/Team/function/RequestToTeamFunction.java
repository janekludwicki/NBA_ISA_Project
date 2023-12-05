package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.function;

import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto.PutTeamRequest;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.entity.Team;

import java.util.UUID;
import java.util.function.Function;

public class RequestToTeamFunction implements Function<PutTeamRequest, Team> {

    @Override
    public Team apply(PutTeamRequest request) {
        return Team.builder()
                .teamID(UUID.randomUUID())
                .name(request.getName())
                .city(request.getCity())
                .coach(request.getCoach())
                .noOfChampionships(request.getNoOfChampionships())
                .build();
    }
}
