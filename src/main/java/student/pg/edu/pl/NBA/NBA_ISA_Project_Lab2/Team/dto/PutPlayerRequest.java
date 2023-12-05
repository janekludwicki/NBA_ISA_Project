package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.team.dto;

import jdk.jfr.StackTrace;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutPlayerRequest {
    private UUID playerID;
}
