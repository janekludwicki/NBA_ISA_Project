package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public void remove(Team team) {
        teamRepository.delete(team);
    }

    public Optional<Team> findByName(String teamName) {
        return teamRepository.findByName(teamName);
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
