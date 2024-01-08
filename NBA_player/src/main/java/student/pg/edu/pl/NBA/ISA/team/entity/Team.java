package student.pg.edu.pl.NBA.ISA.team.entity;

import student.pg.edu.pl.NBA.ISA.player.entity.Player;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "teams")
public class Team implements Serializable {
    @Id
    @Column(name="team_id")
    private UUID teamID;
    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Builder.Default
    private List<Player> players = new LinkedList<>();
}
