package student.pg.edu.pl.NBA.ISA.team.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import student.pg.edu.pl.NBA.ISA.team.dto.*;

import java.util.UUID;

@RequestMapping("/api")
public interface TeamController {

        @PutMapping("/teams/{teamID}/players")
        @ResponseStatus(HttpStatus.OK)
        void putPlayer(
                @PathVariable("teamID")
                UUID playerID,
                @RequestBody
                PutPlayerRequest request
        );

        @PutMapping("/teams/{id}")
        @ResponseStatus(HttpStatus.ACCEPTED)
        void putTeam(
                @PathVariable("id")
                UUID id,
                @RequestBody
                PutTeamRequest request
        );

        @DeleteMapping("/teams/{id}")
        @ResponseStatus(HttpStatus.ACCEPTED)
        void deleteTeam(
                @PathVariable("id")
                UUID id
        );
}
