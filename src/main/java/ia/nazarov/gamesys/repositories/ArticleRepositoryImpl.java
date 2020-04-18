package ia.nazarov.gamesys.repositories;

import ia.nazarov.gamesys.models.Article;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    final JdbcTemplate jdbcTemplate;

    public ArticleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Article> findArticleByGUID(String guid) {
        try {
            Article article = jdbcTemplate.queryForObject("SELECT * FROM articles WHERE guid = ?",
                    new Object[] { guid },
                    new BeanPropertyRowMapper<>(Article.class));
            return article != null ? Optional.of(article) : Optional.empty();
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Article article) {
        jdbcTemplate.update("INSERT INTO articles (guid, uri) VALUES(?, ?)",
                new Object[] { article.getId(), article.getSource()});
    }
}
