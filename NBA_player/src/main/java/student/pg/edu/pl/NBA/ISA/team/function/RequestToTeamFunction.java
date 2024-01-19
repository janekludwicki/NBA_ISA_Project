package student.pg.edu.pl.NBA.ISA.team.function;

import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.team.dto.PutTeamRequest;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class RequestToTeamFunction implements BiFunction<UUID, PutTeamRequest, Team> {

    @Override
    public Team apply(UUID id, PutTeamRequest request) {
        return Team.builder()
                .teamID(id)
                .build();
    }
}
