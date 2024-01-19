package student.pg.edu.pl.NBA.ISA.player.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import student.pg.edu.pl.NBA.ISA.player.controller.api.PlayerController;
import student.pg.edu.pl.NBA.ISA.player.dto.*;
import student.pg.edu.pl.NBA.ISA.player.entity.Player;
import student.pg.edu.pl.NBA.ISA.player.function.*;
import student.pg.edu.pl.NBA.ISA.player.service.PlayerService;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;
import student.pg.edu.pl.NBA.ISA.team.service.TeamService;

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
    public void putPlayer(UUID id, PutPlayerRequest request) {
        Optional<Team> team = teamService.findById(request.getTeamID());
        if(team.isPresent()) {
            Player player = requestToPlayerFunction.apply(id, request);
            playerService.addPlayer(player);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    @Override
    public void patchPlayer(UUID id, PatchPlayerRequest request) {
        Optional<Player> players = playerService.findById(id);
        if (players.isPresent()) {
            players.ifPresent(player -> playerService.update(updatePlayerWithRequestFunction.apply(player,
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
