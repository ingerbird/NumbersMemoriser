package ia.nazarov.gamesys.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Word {
    private final String word;
    private final String num;
    private final int usage;
}
