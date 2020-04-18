package ia.nazarov.gamesys.mappers;

import ia.nazarov.gamesys.models.Word;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class WordRowMapper implements RowMapper<Word> {

    @Override
    public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Word(rs.getString("word"), rs.getString("num"), rs.getInt("usage"));
    }
}
