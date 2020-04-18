package ia.nazarov.gamesys.repositories;

import ia.nazarov.gamesys.models.Article;

import java.util.Optional;

public interface ArticleRepository {
    Optional<Article> findArticleByGUID(String guid);
    void save(Article article);
}
