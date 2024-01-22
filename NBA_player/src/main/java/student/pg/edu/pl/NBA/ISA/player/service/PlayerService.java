package student.pg.edu.pl.NBA.ISA.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.pg.edu.pl.NBA.ISA.player.entity.Player;
import student.pg.edu.pl.NBA.ISA.player.repository.PlayerRepository;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public  Optional<Player> findById(UUID id){ return playerRepository.findById(id);}
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

    public void update(Player player) {
        playerRepository.findById(player.getId()).ifPresent(
                player2BUpdated -> {
                    player2BUpdated.setName(player.getName());
                    player2BUpdated.setSurname(player.getSurname());
                    player2BUpdated.setYearOfBirth(player.getYearOfBirth());
                    player2BUpdated.setJerseyNo(player.getJerseyNo());
                    player2BUpdated.setHeight(player.getHeight());
                    player2BUpdated.setPosition(player.getPosition());
                    playerRepository.save(player2BUpdated);
                }
        );
    }
}
