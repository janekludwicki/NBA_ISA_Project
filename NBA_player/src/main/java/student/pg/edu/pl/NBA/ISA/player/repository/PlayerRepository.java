package student.pg.edu.pl.NBA.ISA.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.pg.edu.pl.NBA.ISA.player.entity.Player;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    List<Player> findByTeam(Team team); // This method allows querying players by category
    Optional<Player> findByNameAndSurname(String name, String surname);
}

