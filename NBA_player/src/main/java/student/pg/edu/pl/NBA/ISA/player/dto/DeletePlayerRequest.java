package student.pg.edu.pl.NBA.ISA.player.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class DeletePlayerRequest {
    private UUID id;
}
