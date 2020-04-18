package ia.nazarov.gamesys.repositories;

import ia.nazarov.gamesys.mappers.WordRowMapper;
import ia.nazarov.gamesys.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class WordRepositoryImpl implements WordRepository {
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public WordRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Word> findWordsByNum(String num) {
        return jdbcTemplate.query("SELECT * FROM words WHERE num = ?", new WordRowMapper(), num);
    }

    @Override
    @Transactional
    public void save(Word word) {
        jdbcTemplate.update("INSERT INTO words(word, num)\n" +
                "SELECT ?, ? \n" +
                "WHERE NOT EXISTS(SELECT * FROM words WHERE UPPER(word) = UPPER(?))",
                new Object[] {word.getWord(), word.getNum(), word.getWord()});
        jdbcTemplate.update("UPDATE words SET usage = usage + 1 WHERE UPPER(word) = UPPER(?)", word.getWord());
    }


}
