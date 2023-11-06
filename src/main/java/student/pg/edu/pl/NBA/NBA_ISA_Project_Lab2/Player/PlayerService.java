package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.Team.Team;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    public void remove(Player player) {
        playerRepository.delete(player);
    }

    public List<Player> findByTeam(Team team) {
        return playerRepository.findByTeam(team);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findByNameAndSurname(String name, String surname) {
        return playerRepository.findByNameAndSurname(name, surname);
    }
}
