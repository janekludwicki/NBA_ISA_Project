package student.pg.edu.pl.NBA.ISA.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {
    Optional<Team> findByName(String teamName);
    Optional<Team> findById(UUID id);
}