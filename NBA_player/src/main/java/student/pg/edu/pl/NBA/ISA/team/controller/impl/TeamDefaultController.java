package student.pg.edu.pl.NBA.ISA.team.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import student.pg.edu.pl.NBA.ISA.team.dto.*;
import student.pg.edu.pl.NBA.ISA.player.service.PlayerService;
import student.pg.edu.pl.NBA.ISA.team.controller.api.TeamController;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.function.RequestToTeamFunction;
import student.pg.edu.pl.NBA.ISA.team.service.TeamService;

import java.util.UUID;

@RestController
@Log
@RequiredArgsConstructor
public class TeamDefaultController implements TeamController {
    private final TeamService teamService;

    private final PlayerService playerService;

    private final RequestToTeamFunction requestToTeamFunction;

    @Override
    public void putTeam(PutTeamRequest request) {
        Team team = requestToTeamFunction.apply(request);
        teamService.addTeam(team);
    }

    @Override
    public void putPlayer(UUID teamID, PutPlayerRequest request) {
        teamService.findById(teamID).ifPresent(team -> playerService.findById(request.getPlayerID()).ifPresentOrElse(
                player -> {
                    player.setTeam(team);
                    playerService.addPlayer(player);
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        ));
    }

    @Override
    public void deleteTeam(UUID id) {
        teamService.findById(id).ifPresentOrElse(
                teamService::remove,
                ()->{ throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        );
    }
}
