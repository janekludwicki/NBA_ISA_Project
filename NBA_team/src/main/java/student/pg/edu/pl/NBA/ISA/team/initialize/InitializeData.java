package student.pg.edu.pl.NBA.ISA.team.initialize;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.service.TeamService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final TeamService teamService;

    @Autowired
    public InitializeData(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (teamService.findAll().isEmpty()) {
            Team LakersTeam = Team.builder()
                    .teamID(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Lakers")
                    .city("Los Angeles")
                    .coach("Darvin Ham")
                    .noOfChampionships(17)
                    .build();

            teamService.addTeam(LakersTeam);

            Team CelticsTeam = Team.builder()
                    .teamID(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("Celtics")
                    .city("Boston")
                    .coach("Joe Mazzulla")
                    .noOfChampionships(17)
                    .build();

            teamService.addTeam(CelticsTeam);
        }
    }
}