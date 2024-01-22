package student.pg.edu.pl.NBA.ISA.team.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.event.repository.api.TeamEventRepository;

import java.util.UUID;

@Repository
public class TeamEventRestRepository implements TeamEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public TeamEventRestRepository(RestTemplate template) {this.restTemplate = template;}

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/teams/{id}", id);
    }

    @Override
    public void add(Team team) {
        restTemplate.put("/api/teams/{id}", team, team.getId());
    }
}