package student.pg.edu.pl.NBA.ISA.player.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDto implements Comparable<PlayerDto>{
    private Integer playerID;
    private String name;
    private String surname;
    private Integer age;
    private Integer jerseyNo;
    private Integer Height;
    private String position;
    private String Team;

    public int compareTo(PlayerDto other) { return this.playerID.compareTo(other.playerID); }

    @Override
    public String toString() {
        return "NBA_Player{" +
                "playerID='" + playerID + '\'' +
                "name='" + name + '\'' +
                "surname='" + surname + '\'' +
                "age='" + age + '\'' +
                "jersey number='" + jerseyNo + '\'' +
                "height='" + Height + '\'' +
                "position='" + position + '\'' +
                "team='" + Team + '}';
    }
}
