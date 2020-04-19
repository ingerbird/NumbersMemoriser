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
            new Article("3", "source3", "data3")
    );

    Map<String, Article> articleMap = new HashMap<>();

    DuplicateFilterTest() {
        articleMap.put("1", new Article("1", "source1", "data1"));
        articleMap.put("2", new Article("2", "source2", "data2"));
        articleRepository = Mockito.mock(ArticleRepository.class);
        Mockito.when(articleRepository.findArticleByGUID("1")).thenReturn(Optional.of(articleMap.get("1")));
        Mockito.when(articleRepository.findArticleByGUID("2")).thenReturn(Optional.of(articleMap.get("2")));
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