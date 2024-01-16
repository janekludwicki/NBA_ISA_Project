package student.pg.edu.pl.NBA.ISA.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.event.repository.api.TeamEventRepository;
import student.pg.edu.pl.NBA.ISA.team.repository.TeamRepository;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Service
public class TeamService {
   private final TeamRepository teamRepository;
   private final TeamEventRepository teamEventRepository;

   @Autowired
   public TeamService(TeamRepository teamRepository, TeamEventRepository teamEventRepository) {
       this.teamRepository = teamRepository;
       this.teamEventRepository = teamEventRepository;
   }

    public Optional<Team> findById(UUID id){ return teamRepository.findById(id); }

    public void addTeam(Team team) {
        teamRepository.save(team);
        teamEventRepository.add(team);
    }

    public void remove(Team team) {
       teamRepository.delete(team);
       teamEventRepository.delete(team.getTeamID());
   }

    public Optional<Team> findByName(String teamName) {
        return teamRepository.findByName(teamName);
    }

    public void update (Team team){
            teamRepository.findById(team.getTeamID()).ifPresent(
                    team2BUpdated -> {
                        team2BUpdated.setName(team.getName());
                        team2BUpdated.setCoach(team.getCoach());
                        team2BUpdated.setCity(team.getCity());
                        team2BUpdated.setNoOfChampionships(team.getNoOfChampionships());
                        teamRepository.save(team2BUpdated);
                    }
            );
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
