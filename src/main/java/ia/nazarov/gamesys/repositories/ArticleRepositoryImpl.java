package ia.nazarov.gamesys.repositories;

import ia.nazarov.gamesys.models.Article;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    @Override
    public Optional<Article> getArticleByGUID(String guid) {
        return Optional.empty();
    }
}
