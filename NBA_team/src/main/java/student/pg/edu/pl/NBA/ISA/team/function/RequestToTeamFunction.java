package student.pg.edu.pl.NBA.ISA.team.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.team.dto.PutTeamRequest;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.UUID;
import java.util.function.Function;

@Component
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
