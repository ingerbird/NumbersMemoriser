package ia.nazarov.gamesys.services;

import ia.nazarov.gamesys.models.Word;
import ia.nazarov.gamesys.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordsServiceImpl implements WordsService {
    final WordRepository wordRepository;

    @Autowired
    public WordsServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<String> findWordsByNum(String num) {
        return wordRepository.findWordsByNum(num).stream()
                .map(Word::getWord)
                .collect(Collectors.toList());
    }
}
