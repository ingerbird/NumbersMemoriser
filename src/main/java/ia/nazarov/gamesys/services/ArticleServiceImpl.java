package ia.nazarov.gamesys.services;

import ia.nazarov.gamesys.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Cacheable("articles")
    public boolean isArticleExists(String guid) {
        return articleRepository.getArticleByGUID(guid).isPresent();
    }
}
