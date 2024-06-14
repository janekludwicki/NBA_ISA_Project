package NBA.Player;
import NBA.Team.Team;

import lombok.*;

import java.util.Objects;
import java.util.Comparator;
import java.util.List;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Player implements Comparable<Player>, Serializable {
    private Integer playerID;
    private String name;
    private String surname;
    private Integer age;
    private Integer jerseyNo;
    private Integer Height;
    private String position;
    private Team team;

    @Override
    public int hashCode() { return Objects.hash(playerID, name, surname, age, jerseyNo, Height, position, team); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o ==null || getClass() !=  o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerID, player.playerID) &&
                Objects.equals(name, player.name) &&
                Objects.equals(surname, player.surname) &&
                Objects.equals(age, player.age) &&
                Objects.equals(jerseyNo, player.jerseyNo) &&
                Objects.equals(Height, player.Height) &&
                Objects.equals(position, player.position) &&
                Objects.equals(team, player.team);
    }

    @Override
    public int compareTo(Player other) { return this.playerID.compareTo(other.playerID); }

    @Override
    public String toString() {
        return "NBA_Player{" +
                "playerID='" + playerID + '\'' +
                "name='" + name + '\'' +
                "surname='" + surname + '\'' +
                "age='" + age + '\'' +
                "jersey number='" + jerseyNo + '\'' +
                "height='" + Height + '\'' +
                "position='" + position + '\'' + '}';
    }
}
