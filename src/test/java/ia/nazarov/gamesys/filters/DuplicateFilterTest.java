package ia.nazarov.gamesys.filters;

import ia.nazarov.gamesys.models.Article;
import ia.nazarov.gamesys.repositories.ArticleRepository;
import ia.nazarov.gamesys.services.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DuplicateFilterTest {
    ArticleRepository articleRepository;
    List<Article> articles = Arrays.asList(
            new Article("1", "source1", "data1"),
            new Article("2", "source2", "data2"),
            new Article("1", "source1", "data1")
    );

    Map<String, Article> articleMap = new HashMap<>();

    DuplicateFilterTest() {
        articles.forEach(article -> articleMap.put(article.getId(), article));
        articleRepository = Mockito.mock(ArticleRepository.class);
        Mockito.when(articleRepository.getArticleByGUID("1")).thenReturn(Optional.of(articleMap.get("1")));
        Mockito.when(articleRepository.getArticleByGUID("2")).thenReturn(Optional.of(articleMap.get("2")));
    }


    @Test
    void filterTest() {
        ArticleServiceImpl articleService = new ArticleServiceImpl(articleRepository);
        DuplicateFilter duplicateFilter = new DuplicateFilter(articleService);
        Set<Article> filtered = duplicateFilter.filter(articles);
        assertTrue(filtered.size() > 0);
        assertTrue(filtered.size() < articles.size());
    }
}