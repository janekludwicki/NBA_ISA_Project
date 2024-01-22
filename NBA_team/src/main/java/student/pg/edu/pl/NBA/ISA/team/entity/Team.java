package student.pg.edu.pl.NBA.ISA.team.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "teams")
public class Team implements Comparable<Team>, Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    private String name;
    private String city;
    private String coach;
    @Column(name="no_of_championships")
    private Integer noOfChampionships;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, coach, noOfChampionships);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) &&
                Objects.equals(name, team.name) &&
                Objects.equals(city, team.city) &&
                Objects.equals(coach, team.coach) &&
                Objects.equals(noOfChampionships, team.noOfChampionships);
    }

    @Override
    public int compareTo(Team other) { return this.id.compareTo(other.id); }

    @Override
    public String toString() {
        return "NBA_Team{" +
                "teamID='" + id + '\'' +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", coach='" + coach + '\'' +
                ", Number of Championships='" + noOfChampionships + '\'' +
                '}';
    }
}
