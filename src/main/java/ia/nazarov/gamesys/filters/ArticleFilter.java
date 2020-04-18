package ia.nazarov.gamesys.filters;

import ia.nazarov.gamesys.models.Article;

import java.util.List;
import java.util.Set;

public interface ArticleFilter {
    Set<Article> filter(List<Article> articles);
}
