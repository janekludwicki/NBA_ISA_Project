package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto.*;

import java.util.UUID;

@RequestMapping("/api")
public interface TeamController {

        @GetMapping("/teams")
        @ResponseStatus(HttpStatus.OK)
        @ResponseBody
        GetTeamsResponse getTeams();

        @GetMapping("/teams/{id}")
        @ResponseStatus(HttpStatus.OK)
        @ResponseBody
        GetTeamResponse getTeam(
                @PathVariable("id")
                UUID id
        );

        @PostMapping("/teams")
        @ResponseStatus(HttpStatus.CREATED)
        void putTeam(
                @RequestBody
                PutTeamRequest request
        );

        @PutMapping("/teams/{teamID}/players")
        @ResponseStatus(HttpStatus.OK)
        void putPlayer(
                @PathVariable("teamID")
                UUID playerID,
                @RequestBody
                PutPlayerRequest request
        );

        @PatchMapping("/teams/{id}")
        @ResponseStatus(HttpStatus.ACCEPTED)
        void patchTeam(
                @PathVariable("id")
                UUID id,
                @RequestBody
                PatchTeamRequest request
        );


        @DeleteMapping("/teams/{id}")
        @ResponseStatus(HttpStatus.ACCEPTED)
        void deleteTeam(
                @PathVariable("id")
                UUID id
        );
}
