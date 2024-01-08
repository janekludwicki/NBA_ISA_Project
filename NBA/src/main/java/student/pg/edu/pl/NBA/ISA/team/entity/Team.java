package student.pg.edu.pl.NBA.ISA.team.entity;

import student.pg.edu.pl.NBA.ISA.player.entity.Player;
import lombok.*;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "teams")
public class Team implements Comparable<Team> {
    @Id
    @Column(name="team_id")
    private UUID teamID;
    private String name;
    private String city;
    private String coach;
    @Column(name="no_of_championships")
    private Integer noOfChampionships;
    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Builder.Default
    private List<Player> players = new LinkedList<>();


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
                '}';
    }
}
