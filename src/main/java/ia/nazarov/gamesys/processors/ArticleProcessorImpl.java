package ia.nazarov.gamesys.processors;

import ia.nazarov.gamesys.mappers.Word2NumMapperRu;
import ia.nazarov.gamesys.models.Article;
import ia.nazarov.gamesys.models.Word;
import ia.nazarov.gamesys.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.StringTokenizer;

@Component
public class ArticleProcessorImpl implements ArticleProcessor {
    final WordRepository wordRepository;
    final Word2NumMapperRu word2NumMapper;

    @Autowired
    public ArticleProcessorImpl(WordRepository wordRepository, Word2NumMapperRu word2NumMapper) {
        this.wordRepository = wordRepository;
        this.word2NumMapper = word2NumMapper;
    }

    @Override
    public void process(Article article) {
        StringTokenizer tokenizer = new StringTokenizer(article.getData());
        while (tokenizer.hasMoreTokens()) {
            processToken(tokenizer.nextToken());
        }
    }

    private void processToken(String token) {
        Word word = new Word(token, word2NumMapper.map(token), 0);
        wordRepository.save(word);
    }
}
