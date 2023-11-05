package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.Player.Player;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.Player.PlayerService;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.Team.Team;
import student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.Team.TeamService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class NbaApplicationCommand implements CommandLineRunner {
    private final TeamService teamService;

    private final PlayerService playerService;

    @Autowired
    public NbaApplicationCommand(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    private void printMenu() {
        System.out.println("NBA Application");
        System.out.println("Commands:");
        System.out.println("get_players_by_team - List all players from given team");
        System.out.println("all - List all players and teams");
        System.out.println("remove - delete either player or team");
        System.out.println("add - add either player or team");
        System.out.println("quit - Exit the application");
        System.out.print("Enter a command: ");
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "get_players_by_team" -> {
                    System.out.println("Enter team's name: ");
                    String teamName = scanner.next();
                    Optional<Team> team = teamService.findByName(teamName);
                    if (teamService.findByName(teamName).isPresent()) {
                        List<Player> players = playerService.findByTeam(team.get());
                        if (players.isEmpty())
                            System.out.println("No players in this team!");
                        else {
                            System.out.println("Players in this Team:  ");
                            players.forEach(player -> System.out.println("Player: " + player.toString()));
                        }
                    }
                    else
                        System.out.println("Team does not exist!!!");
                }
                case "all" -> {
                    if (playerService.findAll().isEmpty())
                        System.out.println("There are no players!!");
                    else
                        playerService.findAll().forEach(player -> System.out.println(player.toString()));
                    if (teamService.findAll().isEmpty())
                        System.out.println("There are no teams!!");
                    else
                        teamService.findAll().forEach(team -> System.out.println(team.toString()));
                }
                case "add" -> {
                    command = scanner.next();
                    switch (command){
                        case ("player") -> {
                            System.out.println("Enter player's name and surname:  ");
                            String name = scanner.next();
                            String surname = scanner.next();
                            System.out.println("Enter player's date of birth:  ");
                            Integer yearOfBirth = Integer.parseInt(scanner.next());
                            System.out.println("Enter jersey number:  ");
                            Integer jerseyNo = Integer.parseInt(scanner.next());
                            System.out.println("Enter height (in cm):  ");
                            Integer height = Integer.parseInt(scanner.next());
                            System.out.println("Enter position:  ");
                            String position = scanner.next();
                            System.out.println("Enter Team's name:  ");
                            String teamName = scanner.next();
                            Optional<Team> team = teamService.findByName(teamName);
                            if(team.isPresent()) {
                                playerService.addPlayer(Player.builder().name(name).surname(surname).
                                        yearOfBirth(yearOfBirth).jerseyNo(jerseyNo).Height(height).position(position).
                                        team(team.get()).playerID(UUID.randomUUID()).build());
                            }
                            else
                                System.out.println("Such team does not exist!!");
                        }
                        case ("team") -> {
                            System.out.println("Enter team's city and name:  ");
                            String city = scanner.next();
                            String name = scanner.next();
                            System.out.println("Enter coach's name and surname:  ");
                            String coachName = scanner.next();
                            String surname = scanner.next();
                            String coach = coachName + surname;
                            System.out.println("Enter team's number of championships:  ");
                            Integer noOfChampionships = Integer.parseInt(scanner.next());
                            teamService.addTeam(Team.builder().city(city).name(name).coach(coach).
                                    noOfChampionships(noOfChampionships).teamID(UUID.randomUUID()).build());
                        }
                    }

                }
                case "remove" -> {
                    command = scanner.next();
                    switch (command){
                        case ("player") -> {
                            System.out.println("Enter player's name and surname:  ");
                            String name = scanner.next();
                            String surname = scanner.next();
                            Optional<Player> player = playerService.findByNameAndSurname(name, surname);
                            if (player.isPresent()) {
                                playerService.remove(player.get());
                                System.out.println("Player was deleted");
                            }
                            else
                                System.out.println("Player does not exist!!");
                        }
                        case ("team") -> {
                            System.out.println("Enter team's name:  ");
                            String name = scanner.next();
                            Optional<Team> team = teamService.findByName(name);
                            if (team.isPresent()) {
                                teamService.remove(team.get());
                                System.out.println("Team was deleted");
                            }
                            else
                                System.out.println("Team does not exist!!");
                        }
                    }
                }
                case "quit" -> {
                    break main_loop;
                }
                default -> { printMenu();}
            }

        }
        System.exit(0);
    }
}
