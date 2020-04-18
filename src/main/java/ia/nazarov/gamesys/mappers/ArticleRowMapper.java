package ia.nazarov.gamesys.mappers;


import ia.nazarov.gamesys.models.Article;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {

    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Article(rs.getString("guid"),
                rs.getString("uri"),
                // We don't store article content in database- it doesn't make sense now
                "");
    }
}
