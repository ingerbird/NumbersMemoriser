package ia.nazarov.gamesys.filters;

import ia.nazarov.gamesys.models.Article;
import ia.nazarov.gamesys.services.ArticleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DuplicateFilter implements ArticleFilter {
    final ArticleService articleService;

    public DuplicateFilter(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public Set<Article> filter(List<Article> articles) {
        return articles.stream()
                .filter(article -> articleService.isArticleExists(article.getId()))
                .collect(Collectors.toSet()); }
}
