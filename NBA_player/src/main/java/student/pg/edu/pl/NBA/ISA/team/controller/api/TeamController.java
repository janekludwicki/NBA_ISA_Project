package student.pg.edu.pl.NBA.ISA.team.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import student.pg.edu.pl.NBA.ISA.team.dto.*;

import java.util.UUID;

@RequestMapping("/api")
public interface TeamController {

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

        @DeleteMapping("/teams/{id}")
        @ResponseStatus(HttpStatus.ACCEPTED)
        void deleteTeam(
                @PathVariable("id")
                UUID id
        );
}
