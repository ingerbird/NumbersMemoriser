package ia.nazarov.gamesys.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Article {
    private String id;
    private String source;
    private String data;
}
