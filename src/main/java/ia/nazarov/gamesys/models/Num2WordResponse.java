package ia.nazarov.gamesys.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Num2WordResponse extends BasicResponse {
    final List<String> words;
    public Num2WordResponse(String message, List<String> words) {
        super(message);
        this.words = words;
    }
}
