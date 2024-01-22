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
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Player implements Comparable<Player>, Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    private String name;
    private String surname;
    @Column(name="year_of_birth")
    private Integer yearOfBirth;
    @Column(name="jersey_number")
    private Integer jerseyNo;
    @Column(name="height")
    private Integer height;
    private String position;
    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;

    @Override
    public int hashCode() { return Objects.hash(id, name, surname, yearOfBirth, jerseyNo, height, position, team); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o ==null || getClass() !=  o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(name, player.name) &&
                Objects.equals(surname, player.surname) &&
                Objects.equals(yearOfBirth, player.yearOfBirth) &&
                Objects.equals(jerseyNo, player.jerseyNo) &&
                Objects.equals(height, player.height) &&
                Objects.equals(position, player.position) &&
                Objects.equals(team, player.team);
    }

    @Override
    public int compareTo(Player other) { return this.id.compareTo(other.id); }

    @Override
    public String toString() {
        return "NBA_Player{" +
                "playerID='" + id + '\'' +
                "name='" + name + '\'' +
                "surname='" + surname + '\'' +
                "age='" + yearOfBirth + '\'' +
                "jersey number='" + jerseyNo + '\'' +
                "height='" + height + '\'' +
                "position='" + position + '\'' +
                '}';
    }
}