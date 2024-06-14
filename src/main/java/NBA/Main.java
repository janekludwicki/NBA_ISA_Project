package NBA;


import NBA.Team.Team;
import NBA.Player.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Create an instance list with NBA teams and their players
        List<Team> NbaTeams = TeamsCreator();

        //Task 2:
        //Print NBA teams in their original order  using lambda
        NbaTeams.forEach(team -> System.out.println(team.toString()));

        //Task 3:
        //Use stream pipelines to collect and print all elements
        Set<Player> allPlayers = NbaTeams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .collect(Collectors.toSet());
        System.out.println("All NBA Players Set:");
        allPlayers.forEach((player -> System.out.println("Player: " + player.toString())));

        //Task 4:
        //Use stream pipeline to filter, sort and print collection of all elements created earlier
        allPlayers.stream()
                .filter(player -> player.getAge().compareTo(27) >= 0)
                .sorted((player1, player2) -> Integer.compare(player1.getHeight(), player2.getHeight()))
                .forEach((player -> System.out.println("Player" + player.toString())));
        //Task 5:
        //Use single Stream pipeline transform elements collection created earlier into
        //steam of DTO objects and sorting them
        List<PlayerDto> playerDtos = NbaTeams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .map(player -> new PlayerDto(player.getPlayerID(),
                        player.getName(),
                        player.getSurname(),
                        player.getAge(),
                        player.getJerseyNo(),
                        player.getHeight(),
                        player.getPosition(),
                        player.getTeam().getName()))
                .sorted() // Using natural order
                .collect(Collectors.toList());
        //print
        playerDtos.forEach(dto -> System.out.println("Player DTO: " + dto));

        //Task 6:
        //Use serialization mechanism to store collection of categories in the binary file
        serializeNbaTeams(NbaTeams, "nba_teams.ser");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nba_teams.ser"))) {
            List<Team> deserializedTeams = (List<Team>) ois.readObject();

            // Print all NBA teams and their players after deserialization
            System.out.println("NBA Teams and Players (After Deserialization):");
            deserializedTeams.forEach(team -> {
                System.out.println("Team: " + team.toString());
                team.getPlayers().forEach(player -> System.out.println("   Player: " + player.toString()));
            });
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Task 7:
        //Using Stream API with a custom thread pool
        // Adjust the pool size as needed
        ForkJoinPool customThreadPool = new ForkJoinPool(2);

        allPlayers.parallelStream().forEach(player -> {
            customThreadPool.submit(() -> {
                try {
                    System.out.println("Player practicing: " + player.getName() + " " + player.getSurname());
                    // Simulate workload with Thread.sleep()
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        customThreadPool.shutdown();
        try {
            customThreadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static List<Team> TeamsCreator() {
        List<Team> NbaTeams = new ArrayList<>();

        List<Player> LakersPlayers = new ArrayList<>();
        List<Player> CelticsPlayers = new ArrayList<>();


        Team LakersTeam = Team.builder()
                .teamID(1)
                .name("Lakers")
                .city("Los Angeles")
                .coach("Darvin Ham")
                .noOfChampionships(17)
                .players(LakersPlayers)
                .build();

        Team  CelticsTeam = Team.builder()
                .teamID(2)
                .name("Celtics")
                .city("Boston")
                .coach("Joe Mazzulla")
                .noOfChampionships(17)
                .players(CelticsPlayers)
                .build();

        Player LebronJames = Player.builder()
                .playerID(1)
                .name("Lebron")
                .surname("James")
                .age(38)
                .jerseyNo(23)
                .Height(206)
                .position("SF")
                .team(LakersTeam)
                .build();

        LakersPlayers.add(LebronJames);

        Player AnthonyDavis = Player.builder()
                .playerID(2)
                .name("Anthony")
                .surname("Davis")
                .age(30)
                .jerseyNo(3)
                .Height(208)
                .position("PF/C")
                .team(LakersTeam)
                .build();

        LakersPlayers.add(AnthonyDavis);

        Player JaysonTatum = Player.builder()
                .playerID(3)
                .name("Jayson")
                .surname("Tatum")
                .age(25)
                .jerseyNo(0)
                .Height(203)
                .position("SF")
                .team(CelticsTeam)
                .build();

        CelticsPlayers.add(JaysonTatum);

        Player JaylenBrown = Player.builder()
                .playerID(4)
                .name("Jaylen")
                .surname("Brown")
                .age(27)
                .jerseyNo(7)
                .Height(198)
                .position("SG")
                .team(CelticsTeam)
                .build();

        CelticsPlayers.add(JaylenBrown);


        NbaTeams.add(LakersTeam);
        NbaTeams.add(CelticsTeam);

        return NbaTeams;
    }

    private static void serializeNbaTeams(List<Team> NbaTeams, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(NbaTeams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

