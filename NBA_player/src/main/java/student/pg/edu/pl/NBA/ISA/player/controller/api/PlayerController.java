package student.pg.edu.pl.NBA.ISA.player.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import student.pg.edu.pl.NBA.ISA.player.dto.*;

import java.util.UUID;

@RequestMapping("/api")
public interface PlayerController {

    @GetMapping("/players")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getPlayers();

    @GetMapping("/players/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayerResponse getPlayer(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/teams/{id}/players")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersByTeam getPlayersByTeam(
            @PathVariable("id")
            UUID id
    );

    @PutMapping ("/players/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putPlayer(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutPlayerRequest request
    );

    @PatchMapping("/players/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void patchPlayer(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchPlayerRequest request
    );


    @DeleteMapping("/players/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deletePlayer(
            @PathVariable("id")
            UUID id
    );
}
