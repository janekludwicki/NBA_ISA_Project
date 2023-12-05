package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.controller.api.PlayerController;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.dto.*;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.entity.Player;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.function.*;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.service.PlayerService;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.entity.Team;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.service.TeamService;

import java.util.Optional;
import java.util.UUID;

@RestController
@Log
@RequiredArgsConstructor
public class PlayerDefaultController implements PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;

    private final RequestToPlayerFunction requestToPlayerFunction;
    private final PlayersByTeamToResponseFunction playersByTeamToResponseFunction;
    private final PlayersToResponseFunction playersToResponseFunction;
    private final PlayerToResponseFunction playerToResponseFunction;
    private final UpdatePlayerWithRequestFunction updatePlayerWithRequestFunction;

    /*public PlayerDefaultController (PlayerService playerService,
    TeamService teamService, RequestToPlayerFunction requestToPlayerFunction,
    PlayersByTeamToResponseFunction playersByTeamToResponseFunction,
    PlayersToResponseFunction playersToResponseFunction,
    PlayerToResponseFunction playerToResponseFunction,
    UpdatePlayerWithRequestFunction updatePlayerWithRequestFunction) {
        this.playerService = playerService;
        this.playersByTeamToResponseFunction = playersByTeamToResponseFunction;
        this.requestToPlayerFunction = requestToPlayerFunction;
        this.teamService = teamService;
        this.playersToResponseFunction = playersToResponseFunction;
        this.playerToResponseFunction = playerToResponseFunction;
        this.updatePlayerWithRequestFunction = updatePlayerWithRequestFunction;
    }*/

    @Override
    public GetPlayersResponse getPlayers() {
        return playersToResponseFunction.apply(playerService.findAll());
    }

    @Override
    public GetPlayerResponse getPlayer(UUID id) {
        return playerService.findById(id).map(playerToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
    }

    @Override
    public GetPlayersByTeam getPlayersByTeam(UUID id) {
        Optional<Team> team = teamService.findById(id);

        if (team.isPresent())
            return playersByTeamToResponseFunction.apply(team.get().getPlayers());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @Override
    public void putPlayer(PutPlayerRequest request) {
        Optional<Team> team = teamService.findById(request.getTeamID());
        if(team.isPresent()) {
            Player player = requestToPlayerFunction.apply(request);
            playerService.addPlayer(player);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    @Override
    public void patchPlayer(UUID id, PatchPlayerRequest request) {
        Optional<Player> players = playerService.findById(id);
        if (players.isPresent()) {
            players.stream().forEach(player -> playerService.update(updatePlayerWithRequestFunction.apply(player,
                    request)));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deletePlayer(UUID id) {
        playerService.findById(id).ifPresentOrElse(
                playerService::remove,
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }
}
