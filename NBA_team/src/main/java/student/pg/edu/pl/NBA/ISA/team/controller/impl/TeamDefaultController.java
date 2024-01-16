package student.pg.edu.pl.NBA.ISA.team.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import student.pg.edu.pl.NBA.ISA.team.dto.*;
import student.pg.edu.pl.NBA.ISA.team.controller.api.TeamController;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.function.RequestToTeamFunction;
import student.pg.edu.pl.NBA.ISA.team.function.TeamToResponseFunction;
import student.pg.edu.pl.NBA.ISA.team.function.TeamsToResponseFunction;
import student.pg.edu.pl.NBA.ISA.team.function.UpdateTeamWithRequestFunction;
import student.pg.edu.pl.NBA.ISA.team.service.TeamService;

import java.util.UUID;

@RestController
@Log
@RequiredArgsConstructor
public class TeamDefaultController implements TeamController {
    private final TeamService teamService;

    private final TeamsToResponseFunction teamsToResponseFunction;
    private final TeamToResponseFunction teamToResponseFunction;
    private final RequestToTeamFunction requestToTeamFunction;
    private final UpdateTeamWithRequestFunction updateTeamWithRequestFunction;

    @Override
    public GetTeamsResponse getTeams() { return teamsToResponseFunction.apply(teamService.findAll());}

    @Override
    public GetTeamResponse getTeam(UUID id) {
        return teamToResponseFunction.apply(teamService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public void putTeam(PutTeamRequest request) {
        Team team = requestToTeamFunction.apply(request);
        teamService.addTeam(team);
    }

    @Override
    public void patchTeam(UUID id, PatchTeamRequest request) {
        teamService.findById(id).ifPresentOrElse(
                team -> {
                    teamService.update(updateTeamWithRequestFunction.apply(team, request));
                }, () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        );
    }

    @Override
    public void deleteTeam(UUID id) {
        teamService.findById(id).ifPresentOrElse(
                teamService::remove,
                ()->{ throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        );
    }
}
