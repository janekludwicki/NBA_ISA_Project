package student.pg.edu.pl.NBA.ISA.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.repository.TeamRepository;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Service
public class TeamService {
   private final TeamRepository teamRepository;

   @Autowired
   public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Optional<Team> findById(UUID id){ return teamRepository.findById(id); }

    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public void remove(Team team) {
        teamRepository.delete(team);
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
