package student.pg.edu.pl.NBA.ISA.initialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.InitializingBean;
import student.pg.edu.pl.NBA.ISA.player.entity.Player;
import student.pg.edu.pl.NBA.ISA.player.service.PlayerService;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.service.TeamService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class DataInitializer implements InitializingBean {
    private final TeamService teamService;

    private final PlayerService playerService;

    @Autowired
    public DataInitializer(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Team LakersTeam = Team.builder()
                .teamID(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .build();

        teamService.addTeam(LakersTeam);

        Team CelticsTeam = Team.builder()
                .teamID(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .build();

        teamService.addTeam(CelticsTeam);

        Player LebronJames = Player.builder()
                .playerID(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .name("Lebron")
                .surname("James")
                .yearOfBirth(1984)
                .jerseyNo(23)
                .Height(206)
                .position("SF")
                .team(LakersTeam)
                .build();

        playerService.addPlayer(LebronJames);

        Player AnthonyDavis = Player.builder()
                .playerID(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                .name("Anthony")
                .surname("Davis")
                .yearOfBirth(1993)
                .jerseyNo(3)
                .Height(208)
                .position("PF/C")
                .team(LakersTeam)
                .build();

        playerService.addPlayer(AnthonyDavis);

        Player JaysonTatum = Player.builder()
                .playerID(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f"))
                .name("Jayson")
                .surname("Tatum")
                .yearOfBirth(1993)
                .jerseyNo(0)
                .Height(203)
                .position("SF")
                .team(CelticsTeam)
                .build();

        playerService.addPlayer(JaysonTatum);

        Player JaylenBrown = Player.builder()
                .playerID(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d"))
                .name("Jaylen")
                .surname("Brown")
                .yearOfBirth(1996)
                .jerseyNo(7)
                .Height(198)
                .position("SG")
                .team(CelticsTeam)
                .build();

        playerService.addPlayer(JaylenBrown);

    }
}