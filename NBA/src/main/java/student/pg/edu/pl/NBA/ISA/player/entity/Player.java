package student.pg.edu.pl.NBA.ISA.player.entity;


import lombok.*;
import student.pg.edu.pl.NBA.ISA.team.entity.Team;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "players")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Player implements Comparable<Player>, Serializable {
    @Id
    @Column(name="player_id")
    private UUID playerID;
    private String name;
    private String surname;
    @Column(name="year_of_birth")
    private Integer yearOfBirth;
    @Column(name="jersey_no")
    private Integer jerseyNo;
    @Column(name="height")
    private Integer Height;
    private String position;
    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;

    @Override
    public int hashCode() { return Objects.hash(playerID, name, surname, yearOfBirth, jerseyNo, Height, position, team); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o ==null || getClass() !=  o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerID, player.playerID) &&
                Objects.equals(name, player.name) &&
                Objects.equals(surname, player.surname) &&
                Objects.equals(yearOfBirth, player.yearOfBirth) &&
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
                "age='" + yearOfBirth + '\'' +
                "jersey number='" + jerseyNo + '\'' +
                "height='" + Height + '\'' +
                "position='" + position + '\'' +
                "team='" + team.getName() + ' ' +team.getCity() + '\'' +
                '}';
    }
}