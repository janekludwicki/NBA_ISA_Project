package student.pg.edu.pl.NBA.NBA_ISA_Project_Lab2.player.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class DeletePlayerRequest {
    private UUID playerID;
}
