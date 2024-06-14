package NBA.Team;

import NBA.Player.Player;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Team implements Comparable<Team>, Serializable {
    private Integer teamID;
    private String name;
    private String city;
    private String coach;
    private Integer noOfChampionships;
    private List<Player> players;

    @Override
    public int hashCode() {
        return Objects.hash(teamID, name, city, coach, noOfChampionships);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamID, team.teamID) &&
                Objects.equals(name, team.name) &&
                Objects.equals(city, team.city) &&
                Objects.equals(coach, team.coach) &&
                Objects.equals(noOfChampionships, team.noOfChampionships);
    }

    @Override
    public int compareTo(Team other) { return this.teamID.compareTo(other.teamID); }

    @Override
    public String toString() {
        return "NBA_Team{" +
                "teamID='" + teamID + '\'' +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", coach='" + coach + '\'' +
                ", Number of Championships='" + noOfChampionships + '\'' +
                ", Players='" + players + '\'' +
                '}';
    }
}
