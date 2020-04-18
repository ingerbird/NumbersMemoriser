package ia.nazarov.gamesys.readers;

import ia.nazarov.gamesys.models.Article;

import java.util.List;

public interface ArticleFetcher {
    List<Article> fetch(String resource);
}
