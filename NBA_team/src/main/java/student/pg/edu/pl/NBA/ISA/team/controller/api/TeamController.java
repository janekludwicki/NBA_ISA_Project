package student.pg.edu.pl.NBA.ISA.team.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import student.pg.edu.pl.NBA.ISA.team.dto.*;

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

        @PutMapping("/teams/{id}")
        @ResponseStatus(HttpStatus.CREATED)
        void putTeam(
                @PathVariable("id")
                UUID id,
                @RequestBody
                PutTeamRequest request
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
