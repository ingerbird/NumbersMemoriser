package ia.nazarov.gamesys.repositories;

import ia.nazarov.gamesys.models.Word;

import java.util.List;

public interface WordRepository {
    List<Word> findWordsByNum(String num);
    void save(Word word);
}
