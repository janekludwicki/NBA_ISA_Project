package student.pg.edu.pl.NBA.ISA.team.event.repository.api;

import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.UUID;

public interface TeamEventRepository {

    void add(Team team);

    void delete(UUID id);
}