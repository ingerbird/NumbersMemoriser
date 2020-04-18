package ia.nazarov.gamesys.readers;

import ia.nazarov.gamesys.models.Article;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RssFetcherTest {
    RssFetcher rssFeedReader = new RssFetcher();
    @Test
    public void simpleBashReaderTest() {
        List<Article> articles = rssFeedReader.fetch("https://bash.im/rss/");
        System.out.println(String.format("Got %d articles", articles.size()));
        assertTrue(articles.size() > 0);
    }

    @Test
    public void incorrectSourceUrlTest() {
        List<Article> articles = rssFeedReader.fetch("http://notworkingurl.kk/rss/");
        assertEquals(0, articles.size());
    }
}