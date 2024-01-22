package student.pg.edu.pl.NBA.ISA.team.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.team.dto.PatchTeamRequest;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.function.BiFunction;

@Component
public class UpdateTeamWithRequestFunction implements BiFunction<Team, PatchTeamRequest, Team> {

    @Override
    public Team apply(Team entity, PatchTeamRequest request) {
        return Team.builder()
                .id(entity.getId())
                .name(request.getName())
                .city(request.getCity())
                .coach(request.getCoach())
                .noOfChampionships(request.getNoOfChampionships())
                .build();
    }
}
